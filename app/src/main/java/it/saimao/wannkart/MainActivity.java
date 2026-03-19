package it.saimao.wannkart;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.jakewharton.threetenabp.AndroidThreeTen;
import mmcalendar.*;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvDay, tvDate, tvMonth, tvWannKart, tvMyanmarDate;
    private GridLayout calendarLayout;
    private MaterialCardView cardWannKart;
    private LocalDate currentDate;
    private OnSwipeTouchListener onSwipeTouchListener;
    private int emptyDateCounts;
    private int wannKartDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidThreeTen.init(this);
        setContentView(R.layout.activity_main);

        Config.initDefault(new Config.Builder()
                .setCalendarType(CalendarType.ENGLISH)
                .setLanguage(Language.MYANMAR)
                .build());

        initViews();
        setupSwipeListener();

        currentDate = LocalDate.now();
        refreshCalendar();
        setDate(currentDate);
    }

    private void initViews() {
        tvDay = findViewById(R.id.tvDay);
        tvDate = findViewById(R.id.tvDate);
        tvMonth = findViewById(R.id.tvMonth);
        tvMyanmarDate = findViewById(R.id.tvMyanmarDate);
        tvWannKart = findViewById(R.id.tvWannKart);
        cardWannKart = findViewById(R.id.layout2);
        calendarLayout = findViewById(R.id.calenderPane);

        tvWannKart.setOnLongClickListener(v -> changeWannKartName());
    }

    private void setupSwipeListener() {
        onSwipeTouchListener = new OnSwipeTouchListener() {
            public boolean onSwipeRight() { navigateMonth(-1); return true; }
            public boolean onSwipeLeft() { navigateMonth(1); return true; }
        };
        calendarLayout.setOnTouchListener(onSwipeTouchListener);
    }

    private void navigateMonth(int diff) {
        currentDate = currentDate.plusMonths(diff);
        refreshCalendar();

        // Default to first of month unless it's the current month
        LocalDate selection = (currentDate.getMonth() == LocalDate.now().getMonth() &&
                currentDate.getYear() == LocalDate.now().getYear())
                ? LocalDate.now() : currentDate.withDayOfMonth(1);
        setDate(selection);
    }

    private void refreshCalendar() {
        calendarLayout.removeAllViews();
        emptyDateCounts = currentDate.withDayOfMonth(1).getDayOfWeek().getValue();
        if (emptyDateCounts == 7) emptyDateCounts = 0;

        for (int i = 0; i < emptyDateCounts; i++) createEmptyCell();

        int daysInMonth = currentDate.getMonth().length(currentDate.isLeapYear());
        for (int i = 0; i < daysInMonth; i++) createCalendarCell(i);
    }

    private void createEmptyCell() {
        GridLayout.LayoutParams param = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f),
                GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f));
        param.height = 0; param.width = 0;
        calendarLayout.addView(new View(this), param);
    }

    private void createCalendarCell(int dayOffset) {
        GridLayout.LayoutParams param = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f),
                GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f));
        param.height = 0; param.width = 0;

        LocalDate cellDate = currentDate.withDayOfMonth(1).plusDays(dayOffset);
        View dateView = LayoutInflater.from(this).inflate(R.layout.date_button, null);
        dateView.setTag(cellDate);
        dateView.setOnClickListener(this);
        dateView.setOnTouchListener(onSwipeTouchListener);

        updateCellUI(dateView, cellDate, false); // Initial draw
        calendarLayout.addView(dateView, param);
    }

    private void updateCellUI(View view, LocalDate date, boolean isSelected) {
        TextView tvEng = view.findViewById(R.id.tvEngDate);
        TextView tvMoon = view.findViewById(R.id.tvMoonDate);
        ImageView ivMoon = view.findViewById(R.id.ivMoon);

        tvEng.setText(String.valueOf(date.getDayOfMonth()));
        MyanmarDate mDate = MyanmarDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        tvMoon.setText(String.valueOf(mDate.getDayOfMonth() > 15 ? mDate.getDayOfMonth() - 15 : mDate.getDayOfMonth()));

        // Reset Styles
        view.setBackgroundResource(0);
        tvEng.setTypeface(null, Typeface.NORMAL);

        if (isSelected) {
            view.setBackgroundResource(R.drawable.date_selected_background);
            tvEng.setTextColor(Color.WHITE);
            tvMoon.setTextColor(Color.WHITE);
        } else {
            // Today Styling
            if (date.isEqual(LocalDate.now())) {
                view.setBackgroundResource(R.drawable.date_today_outline);
                tvEng.setTextColor(Color.parseColor("#0067FF"));
                tvEng.setTypeface(null, Typeface.BOLD);
            }
            // Weekend/Holiday Styling
            else if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY || HolidayCalculator.isHoliday(mDate)) {
                tvEng.setTextColor(Color.parseColor("#BA1A1A"));
                tvMoon.setTextColor(Color.parseColor("#42474E"));
            } else {
                tvEng.setTextColor(Color.parseColor("#1A1C1E"));
                tvMoon.setTextColor(Color.parseColor("#42474E"));
            }
        }

        // Moon Icons
        ivMoon.setVisibility(mDate.getMoonPhaseValue() == 1 || mDate.getMoonPhaseValue() == 3 ? View.VISIBLE : View.GONE);
        if (mDate.getMoonPhaseValue() == 1) ivMoon.setImageResource(R.drawable.full_moon);
        else if (mDate.getMoonPhaseValue() == 3) ivMoon.setImageResource(R.drawable.new_moon);
    }

    @SuppressLint("DefaultLocale")
    private void setDate(LocalDate localDate) {
        MyanmarDate myDate = MyanmarDate.of(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());

        tvDay.setText(String.format("%02d", localDate.getDayOfMonth()));
        tvMonth.setText(localDate.format(DateTimeFormatter.ofPattern("MMMM yyyy")));
        tvMyanmarDate.setText(myDate.format("S s k, B y k, M p f r En"));

        if (HolidayCalculator.isHoliday(myDate)) {
            tvDate.setText(HolidayCalculator.getHoliday(myDate).get(0));
            updateHeaderColors("#BA1A1A");
        } else {
            tvDate.setText(myDate.format("En"));
            updateHeaderColors("#1A1C1E");
        }

        // Market Day Logic
        long days = ChronoUnit.DAYS.between(LocalDate.of(1996, 1, 1), localDate);
        wannKartDay = (int) (days % 5);
        tvWannKart.setText(Utils.getDayName(this, wannKartDay));
        cardWannKart.setCardBackgroundColor(getWannKartColor());

        highlightCell(localDate);
    }

    private void highlightCell(LocalDate targetDate) {
        for (int i = 0; i < calendarLayout.getChildCount(); i++) {
            View v = calendarLayout.getChildAt(i);
            if (v.getTag() instanceof LocalDate) {
                LocalDate cellDate = (LocalDate) v.getTag();
                updateCellUI(v, cellDate, cellDate.isEqual(targetDate));
            }
        }
    }

    private void updateHeaderColors(String code) {
        tvDate.setTextColor(Color.parseColor(code));
        // Keep the big day number dark for readability
        tvDay.setTextColor(Color.parseColor("#1A1C1E"));
    }

    private int getWannKartColor() {
        // Material 3 Tonal Palette Colors
        int[] colors = {
                0xFFD04D5B, // Muted Red
                0xFF4D7CC0, // Muted Blue
                0xFF5A5F69, // Slate
                0xFFD08D3E, // Muted Orange
                0xFF569A5A  // Muted Green
        };
        return colors[wannKartDay];
    }

    @Override
    public void onClick(View v) {
        if (v.getTag() instanceof LocalDate) setDate((LocalDate) v.getTag());
    }

    private boolean changeWannKartName() {
        // [Existing Dialog Code Here]
        return true;
    }
}