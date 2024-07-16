import java.util.Random;

// This is the back end of this app
public class Generator {
    public static final String Lowercase = "abcdefghijklmnopqrstuvwxyz";
    public static final String Uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String Numbers = "0123456789";
    public static final String Symbols = "`~!@#$%^&*()_+=-[]./,{}|?<>";

    private final Random random;

    public Generator(){random = new Random();}

    public String generatePassword (int lenght, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSymbols){
        StringBuilder passwordBuilder = new StringBuilder();

        String validChars = "";
        if(includeUppercase) validChars += Uppercase;
        if(includeLowercase) validChars += Lowercase;
        if(includeNumbers) validChars += Numbers;
        if(includeSymbols) validChars += Symbols;

        for(int i=0 ; i < lenght ; i++){
            int randomIndex = random.nextInt(validChars.length());
            char randomChar = validChars.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }
        return passwordBuilder.toString();
    }
}
