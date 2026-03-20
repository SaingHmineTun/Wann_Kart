# Wann Kart (ဈေးနေ့) / Wann Kart

Wann Kart is an Android application designed to help users keep track of market days according to the Myanmar calendar system. The app displays both Gregorian and Myanmar calendars with market day indicators, making it easier for users to know when local markets (pa-khongs) are happening in Myanmar.
မြန်မာ့ပြက္ကဒိန်အရေးအသားအရ ဈေးနေ့များကိုစီမံရန်အတွက် Wann Kart သည် Android application ဖြစ်ပါသည်။ ဂရီဂေါရီယန်နှင့် မြန်မာပြက္ကဒိန်တို့ကို ပြသပေးပြီး ဈေးနေ့များကို အမှတ်အသားပြုပေးသည့်အတွက် မြန်မာနိုင်ငံရှိ တိုက်ရိုက်ဈေးများ (ပန်ခမ်းများ) မည်သည့်နေ့တွင်ဖြစ်မည်ဆိုသည်ကို အသုံးပြုသူများ အလွယ်တကူသိရှိနိုင်မည်ဖြစ်ပါသည်။

## Features / အင်္ဂါရပ်များ

- **Dual Calendar Display**: Shows both Gregorian and Myanmar calendar dates
- **Market Day Tracking**: Highlights specific market days (Wann Kart days) in the calendar
- **Moon Phase Indicators**: Displays moon phase icons (full moon and new moon)
- **Holiday Recognition**: Automatically highlights Myanmar holidays
- **Swipe Navigation**: Allows easy navigation between months by swiping left/right
- **Customizable Market Names**: Users can customize the names of market days
- **Bilingual Support**: Supports both Myanmar and English languages
- **အိုင်ဗွီဒီအက်ဒီပလေးပြက္ကဒိန်ပြသမှု**: ဂရီဂေါရီယန်နှင့် မြန်မာပြက္ကဒိန်နှစ်မျိုးလုံးကိုပြသပေးခြင်း
- **ဈေးနေ့စီမံခန့်ခွဲမှု**: ပြက္ကဒိန်တွင် သတ်မှတ်ထားသော ဈေးနေ့များကို (Wann Kart နေ့များကို) မှတ်သားပေးခြင်း
- **လပြည့်၊ လစုန်း အမှတ်အသားများ**: လပြည့်၊ လစုန်း အိုင်ကွန်များကိုပြသပေးခြင်း
- **အားလပ်ရက် အသိအမှတ်ပြုမှု**: မြန်မာအားလပ်ရက်များကို အလိုအလျောက် မှတ်သားပေးခြင်း
- **အိုင်ဗွီဒီအက်ဒီပလေး ကိုယ်ရွေ့မှု**: ဘယ်/ညာ ဆွဲချပေးခြင်းဖြင့် လအကြား အလွယ်ကူစွာ ကိုယ်ရွေ့နှင့်ရယူခြင်း
- **ဈေးနေ့အမည်များ ပြင်ဆင်နိုင်မှု**: အသုံးပြုသူများသည် ဈေးနေ့အမည်များကို ပြင်ဆင်နိုင်ခြင်း
- **ဘာသာစကားနှစ်မျိုးထောက်ပံ့မှု**: မြန်မာနှင့် အင်္ဂလိပ်ဘာသာစကားများကို ထောက်ပံ့ပေးခြင်း

## Market Days / ဈေးနေ့များ

The app tracks 5 rotating market days:
- မူဆယ်ဈေးနေ့ (Mu-say Market Day)
- နမ့်ခမ်းဈေးနေ့ (Nam Kham Market Day)
- စယ်လန့်ဈေးနေ့ (Say Lan Market Day)
- ပန်ခမ်းဈေးနေ့ (Pan Kham Market Day)
- နမ့်စန့်ဈေးနေ့ (Nam San Market Day)

These market days rotate in a 5-day cycle, helping users identify when their local market will be active.
အက်ပ်သည် ဈေးနေ့ ၅ နေ့ကို လည်ပတ်စေပါသည်-
- မူဆယ်ဈေးနေ့ (Mu-say ဈေးနေ့)
- နမ့်ခမ်းဈေးနေ့ (Nam Kham ဈေးနေ့)
- စယ်လန့်ဈေးနေ့ (Say Lan ဈေးနေ့)
- ပန်ခမ်းဈေးနေ့ (Pan Kham ဈေးနေ့)
- နမ့်စန့်ဈေးနေ့ (Nam San ဈေးနေ့)

ယင်း ဈေးနေ့များသည် ၅ ရက်အကြား လည်ပတ်ပါသည်၊ သင့်ဒေသရှိ ဈေးများသည် မည်သည့်နေ့တွင် လုပ်ဆောင်မည်ဆိုသည်ကို အသုံးပြုသူများ သိရှိရန် အကူအညီပေးပါသည်။

## Technical Details / နည်းပညာဆိုင်ရာအသေးစိတ်

- **Language**: Java
- **SDK**: Android API Level 36 (Compile SDK) / API Level 21 (Min SDK)
- **Target SDK**: 34
- **Dependencies**:
  - androidx.appcompat:appcompat:1.7.1
  - com.google.android.material:material:1.13.0
  - com.jakewharton.threetenabp:threetenabp:1.4.9 (Enhanced date/time library)
  - com.github.chanmratekoko:myanmar-calendar:1.1.1.RELEASE (Myanmar calendar support)
- **ဘာသာစကား**: ဂျာဗာ
- **SDK**: Android API Level 36 (Compile SDK) / API Level 21 (Min SDK)
- **Target SDK**: 34
- **မှီခိုမှုများ**:
  - androidx.appcompat:appcompat:1.7.1
  - com.google.android.material:material:1.13.0
  - com.jakewharton.threetenabp:threetenabp:1.4.9 (ရက်စွဲ/အချိန် မြှင့်တင်ထားသော စာကြည့်တိုက်)
  - com.github.chanmratekoko:myanmar-calendar:1.1.1.RELEASE (မြန်မာပြက္ကဒိန်ထောက်ပံ့မှု)

## Architecture / အဆောက်အဦ

The application uses:
- ThreeTenABP for enhanced date/time handling
- Myanmar Calendar library for accurate Myanmar date calculations
- Material Design components for UI consistency
- GridLayout for calendar display
- SharedPreferences for storing customized market day names
အက်ပလီကေးရှင်းသည် အောက်ပါများကိုအသုံးပြုပါသည်:
- ရက်စွဲ/အချိန် မြှင့်တင်မှုအတွက် ThreeTenABP
- မြန်မာရက်စွဲတွက်ချက်မှုများအတွက် မြန်မာပြက္ကဒိန်စာကြည့်တိုက်
- UI တိကျမှုအတွက် Material Design အစိတ်အပိုင်းများ
- ပြက္ကဒိန်ပြသမှုအတွက် GridLayout
- ပြင်ဆင်ထားသော ဈေးနေ့အမည်များကိုသိမ်းဆည်းရန် SharedPreferences

## Customization / ပြင်ဆင်နိုင်မှု

Users can customize market day names by long-pressing on the market day display at the bottom of the screen.
အသုံးပြုသူများသည် မန်းတွင်း၏အောက်ခြမ်းရှိ ဈေးနေ့ပြသမှုကို ရှည်ကြာနှိပ်ခြင်းဖြင့် ဈေးနေ့အမည်များကို ပြင်ဆင်နိုင်ပါသည်။

## About / အကြောင်းအရာ

This application was developed by Saing Hmine Tun (Saimei). For more information or to report issues, visit the GitHub repository or contact the developer through the About section in the app.
ဤအက်ပလီကေးရှင်းကို Saing Hmine Tun (Saimei) မှတည်ဆောက်ခဲ့သည်။ နောက်ထပ်အချက်အလက်များအတွက် သို့မဟုတ် ပြဿနာများကိုအကြောင်းကြားရန် GitHub သိုမှီခြင်း သို့မဟုတ် အက်ပ်ရှိ အကြောင်းအရာအပိုင်းမှတစ်ဆင့် ဖန်တီးသူထံသို့ ဆက်သွယ်ပါ။

## License / လိုင်စင်

This project includes a LICENSE.txt file with the licensing information for the application.
ဤပရောဂျက်တွင် အက်ပလီကေးရှင်းအတွက် လိုင်စင်အချက်အလက်များပါဝင်သော LICENSE.txt ဖိုင်ကို ပါဝင်ပါသည်။

## Version / ဗားရှင်း

Current version: 1.6
လက်ရှိဗားရှင်း: 1.6
