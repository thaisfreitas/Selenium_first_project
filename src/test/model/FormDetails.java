package test.model;

public class FormDetails {

    private String name;
    private String language;
    private String whatIsRuby;
    private String versionsRuby;

    public FormDetails(String name, String language, String whatIsRuby,String versionsRuby){

        this.name = name;
        this.language = language;
        this.whatIsRuby = whatIsRuby;
        this.versionsRuby = versionsRuby;

    }

    public static FormDetails validInfos(){
        long timeMillis = System.currentTimeMillis();
        return new FormDetails("TestName"+timeMillis, "Ruby", "A programming language", "1.8.7");
    }
    public static FormDetails incompleteInfo() {
        return new FormDetails(null,"Ruby", "A programming language", "1.8.7");
    }

    public String getName() {
        return name;
    }

    public String getWhatIsRuby() {
        return whatIsRuby;
    }

    public String getVersionsRuby() {
        return versionsRuby;
    }

    public String getLanguage() {
        return language;
    }

}
