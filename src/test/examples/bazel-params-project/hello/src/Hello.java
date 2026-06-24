import com.google.common.collect.ImmutableList;

public class Hello {
    public static void main(String[] args) {
        var list = ImmutableList.of("hello", "world");
        System.out.println(list);
    }
}
