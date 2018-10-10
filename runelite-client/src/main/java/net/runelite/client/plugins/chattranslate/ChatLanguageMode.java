package net.runelite.client.plugins.chattranslate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ChatLanguageMode
{
    //TODO: Remove languages that the client cannot support
    AFRIKAANS("af"),
    ARABIC("ar"),
    AZERBAIJANI("az"),
    BELARUSIAN("be"),
    BULGARIAN("bg"),
    BENGALI("bn"),
    CATALAN("ca"),
    CZECH("cs"),
    WELSH("cy"),
    DANISH("da"),
    GERMAN("de"),
    GREEK("el"),
    ENGLISH("en"),
    ESPERANTO("eo"),
    SPANISH("es"),
    ESTONIAN("et"),
    BASQUE("eu"),
    PERSIAN("fa"),
    FINNISH("fi"),
    FRENCH("fr"),
    IRISH("ga"),
    GALICIAN("gl"),
    GUJARATI("gu"),
    HINDI("hi"),
    CROATIAN("hr"),
    HAITIANCREOLE("ht"),
    HUNGARIAN("hu"),
    INDONESIAN("id"),
    ICELANDIC("is"),
    ITALIAN("it"),
    HEBREW("iw"),
    JAPANESE("ja"),
    GEORGIAN("ka"),
    KANNADA("kn"),
    KOREAN("ko"),
    LATIN("la"),
    LITHUANIAN("lt"),
    LATVIAN("lv"),
    MACEDONIAN("mk"),
    MALAY("ms"),
    MALTESE("mt"),
    DUTCH("nl"),
    NORWEGIAN("no"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    ALBANIAN("sq"),
    SERBIAN("sr"),
    SWEDISH("sv"),
    SWAHILI("sw"),
    TAMIL("ta"),
    TELUGU("te"),
    THAI("th"),
    FILIPINO("tl"),
    TURKISH("tr"),
    UKRAINIAN("uk"),
    URDU("ur"),
    VIETNAMESE("vi"),
    YIDDISH("yi");
    //CHINESESIMPLIFIED("zh-CN"),
    //CHINESETRADITIONAL("zh-TW");

    private final String name;

    @Override
    public String toString()
    {
        return name;
    }
}
