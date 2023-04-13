import org.apache.commons.lang3.StringUtils;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss(String name) {
        if (name.isEmpty()) {
            System.out.println("Передана пустая строка.");
            return false;
        } else if (name.isBlank()) {
            System.out.println("Вместо имени переданы символы пробела.");
            return false;
        } else if ((name.startsWith(" ")) || (name.endsWith(" "))) {
            System.out.println("Переданное имя и фамилия содержат пробел в начале или в конце.");
            return false;
        } else if (!((name.startsWith(" ")) && (!name.endsWith(" ")))) {
            for (int i = 0; i < name.length(); i++) {
                if ((Character.isWhitespace(name.charAt(i))) && ((name.length() >= 3 && name.length() <= 19))) {
                    System.out.println("Переданное имя и фамилия соответствуют корректной длине и разделены пробелом.");
                    return true;
                } else if (!name.contains(" ")) {
                    System.out.println("Пробелов нет вообще.");
                    return false;
                }
            }
        }
        return false;
    }
}

/*
Между 22 и 23 строками можно поместить код, представленный ниже. В этом случае если передано имя типа А И, код уберёт пробел между буквами и получтся 2
символа, что не соответствует заданию и выведется сообщение. Случай, когда символов больше 19 не реализован. Также случай, когда в передеанном имени или
фамилии есть ещё пробелы, например, Ива н Ива н о в - также не реализован.

                    StringUtils.deleteWhitespace(name);
                    if (name.length() <= 3) {
                        System.out.println("Переданное имя и фамилия НЕ соответствуют корректной длине.");
                        return false;
                    } else if (name.length() >= 19)
 */