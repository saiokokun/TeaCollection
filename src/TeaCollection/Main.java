package TeaCollection;

public class Main {//initialization
        public static void main(String[] args) {

            TeaDatabase tag = new TeaDatabase();
            TeMeny load = new TeMeny();
            load.teaInteraction();
            tag.storageExists();
            EasterEgg skamt = new EasterEgg();
            skamt.skamtExists();
        }
}
