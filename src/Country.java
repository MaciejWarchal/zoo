import java.util.HashMap;
import java.util.Map;

public enum Country {

    Poland("Europe","polish"),
    Australia("Australia","english"),
    Egipt("Africa","egiptyanLanguage"),
    India("Asia","hindi"),
    Usa("America","english");

    final String continent;
    final String language;

    Country(String continent, String language) {
        this.continent = continent;
        this.language = language;
    }

    Map<Country,String> popularReligion=new HashMap<>();




}