package uz.mirkomil.learnjava.ui.lesson.view

import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.databinding.FragmentLessonBinding
import uz.mirkomil.learnjava.model.Test
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.lesson.presenter.LessonPresenter
import uz.mirkomil.learnjava.ui.maruza.view.MaruzaFragment
import uz.mirkomil.learnjava.ui.test.view.TestFragment

class LessonFragment : BaseFragment(R.layout.fragment_lesson), LessonView {

    lateinit var binding: FragmentLessonBinding
    lateinit var presenter: LessonPresenter
    var lessonId = 0
    var subjectId = 0
    var title = ""

    override fun onCreate(view: View) {
        binding = FragmentLessonBinding.bind(view)
        presenter = LessonPresenter(this, Repository.getRepositoryWithApiClient(requireContext()))
        presenter.saveTest(getTestAll())
        for (i in 53 .. 110){
            Log.d("TTT",""+i+"\n")
        }
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
        arguments?.getInt("lesson_id")?.let {
            lessonId = it
        }
        arguments?.getInt("subject_id")?.let {
            subjectId = it
        }
        arguments?.getString("title")?.let {
            title = it
            binding.titleHelp.text = it
        }
        binding.test.setOnClickListener {
            val bundle = bundleOf("lesson_id" to lessonId, "subject_id" to subjectId, "title" to title)
            startFragment(TestFragment(),bundle, isAnimate = true)
        }
        binding.maruza.setOnClickListener {
            val bundle = bundleOf("lesson_id" to lessonId, "subject_id" to subjectId, "title" to title)
            startFragment(MaruzaFragment(), bundle, isAnimate = true)
        }
    }

    fun getTestAll() : ArrayList<Test>{
        val data  = ArrayList<Test>()
        data.add(Test(1,1, 1, "jdk nima", "Java Runtime Environment ", "Java Development Kit (Java dashturlash uskunasi)", "dasturlash muhiti","2"))
        data.add(Test(2,1, 1, "Jdk ni qaysi operatsion tizimlarga yuklasa buladi", "Android operatsion tizim ", "Linux OT", "hamma operatsion tizimlarga","3"))
        data.add(Test(3,1, 1, "jdk qaysi faylda saqlanadi", "d:/program files/java/bin", "c:/program files/java/bin", "c. hech faylda sqalanmaydi,","2"))

        data.add(Test(4,1, 2, "Netbeans nima", "dasturlash muhiti", "dasturlash tili", "komponenta","1"))
        data.add(Test(5,1, 2, "Netbeans qachon ishlab chiqilgan", "1988", "1996","2000","2"))
        data.add(Test(6,1, 2, "Netbeans qaysi dasturlash tillarini qullab quvatlaydi.", "python,html,css", "PHP,c,c++,java","java ,python","2"))
        data.add(Test(7,1, 2, "Netbeans qaysi davlatda paydo bo’lgan", "Rossiya", " CHexiya","Aqsh","2"))
        data.add(Test(8,1, 2, "U 90-yillarning oxirida qaysi korxona tomonidan sotib olingan ", "Sun Microsystems", "Apple","Amazon","1"))

        data.add(Test(9,1, 3, "javada nechta o’zgaruvchi turi bor?", "4", "2","3","3"))
        data.add(Test(10,1, 3, "javada o’zgaruvchi nomlari to’g’ri korsatilgan javobni ko’rsating", "if,switch,int", "int,float,for","int,float,double,char","int,float,double,char"))


        data.add(Test(11,1, 3, "int qancha joy egallaydi", "2", "4","1","4"))
        data.add(Test(12,1, 3, "Float qancha joy egallaydi", "4", "3","2","4   "))
        data.add(Test(13,1, 3, "instance variable bu?", "class ichida e’lon qilinadi","funksiya ichida e’lon qilinadi va bu o’zgaruvchilar lokal (mahalliy) o’zgaruvchilar deyiladi.", "static deb e’lon qilingan  o’zgaruvchi static o’zgaruvchi deyiladi. Bu local(mahalliy) bo’lishi mumkin emas","class ichida e’lon qilinadi"))
        data.add(Test(14,1, 3, "Double qancha joy egallaydi", "4", "5","8","8"))
        data.add(Test(15,1, 3, "Boolean qancha joy egallaydi", "2", "1","4","1"))

        data.add(Test(16,1, 4, "Scanner nima?", "class", "o’zgaruvchi","method","class"))
        data.add(Test(17,1, 4, "scanner class qays paketda saqlanadi", "java.putil", "java.util","java.pacges","java.util"))
        data.add(Test(18,1, 4, "Scanner sc = new Scanner(System.in);\n" + "Bu yerda sc nima?\n", "a.\tO’zgaruvchi", "b.\tScanner class obeykti","c.\tMethod","b.\tScanner class obeykti"))
        data.add(Test(19,1, 4, "String name = sc.nextLine(); \n" + "bunda nima elon qilinyabdi?\n ", "Int nomli o’zgaruvchi", "String nomli o’zgaruvchi","Char nomli o’zgaruvchi","String nomli o’zgaruvchi"))
        data.add(Test(20,1, 4, "Float name = sc.nextFloat(); bunda nima elon qilinyabdi?", "Float nomli o’zgaruvchi", "String nomli o’zgaruvchi","Char nomli o’zgaruvchi","Float nomli o’zgaruvchi"))
        data.add(Test(21,1, 4, "Char name = sc.nextLine(); \n" + "bunda nima elon qilinyabdi?\n", "Int nomli o’zgaruvchi", "String nomli o’zgaruvchi","Char nomli o’zgaruvchi","Char nomli o’zgaruvchi"))
        data.add(Test(22,1, 4, "Int name = sc.nextInt(); bunda nima elon qilinyabdi?", "Int nomli o’zgaruvchi", "String nomli o’zgaruvchi","Char nomli o’zgaruvchi","Int nomli o’zgaruvchi"))

        data.add(Test(23,1, 5, "Javada nechta tanlash operatori mavjud", "1", "2","3","2"))
        data.add(Test(24,1, 5, "Javada tanlash operatori qaysilar ?", "if,swich", "if,for","swich,while","if,swich"))
        data.add(Test(25,1, 5, "quyida tug’ri keltirilgan misolni toping ?", "if(4>6){\n" + "int a=4;}\n" + "else a=6;\n", "if(6){\n" + "int a=4;}\n","if(4){\n" + "int a=4;}\n" + "else a=6;\n","if(4>6){\n" + "int a=4;}\n" + "else a=6;\n"))
        data.add(Test(26,1, 5, "if() qavs ichida  nima tekshiriladi.", "shart", "else","tengsizlik","shart"))
        data.add(Test(27,1, 5, "quyida misolda ekranga nima chiqadi ? if(4>6){\n" + "int a=4;}\n" + "else a=6;\n", "6", "4","hech nima","6"))
        data.add(Test(28,1, 5, "quyida misolda ekranga nima chiqadi ?Int a=6; b=8;\n" + "If(a>b){a=b;}\n" + "Else b=a;\n" + "System.out.println(b);\n", "6", "8","10","6"))
        data.add(Test(29,1, 5, "public class IfExample {\n" + "    public static void main(String[] args) {\n" + "        int xaridorningYoshi=17;\n" + "        if(age < 18){\n" + "            Sytem.out.print(\"Tamaki mahsuloti sotilmasin\");\n" + "        }\n" + "       }\n" + "Ekranda qanday natija chiqadi\n", "17", "Tamaki mahsuloti sotilmasin","18","Tamaki mahsuloti sotilmasin"))

        data.add(Test(30,1, 6, "swich operatori bu-?", "sikl operatori", "shart operatori","tanlash operatori","tanlash operatori"))
        data.add(Test(31,1, 6, "int number=20;\n" + "        switch(number){\n" + "        case 10: System.out.println(\"10\");break;\n" + "        case 20: System.out.println(\"20\");break;\n" + "        case 30: System.out.println(\"30\");break;\n" + "        default:System.out.println(\"Not in 10, 20 or 30\");\n" + "ekranda nima chiqadi\n", "20", "10","30","20"))
        data.add(Test(32,1, 6, ".        int number=10;\n" + "        switch(number){\n" + "        case 10: System.out.println(\"10\");break;\n" + "        case 20: System.out.println(\"20\");break;\n" + "        case 30: System.out.println(\"30\");break;\n" + "        default:System.out.println(\"Not in 10, 20 or 30\");\n" + "ekranda nima chiqadi\n", "20", "10","30","10"))
        data.add(Test(33,1, 6, " int number=100;\n" + "        switch(number){\n" + "        case 10: System.out.println(\"10\");break;\n" + "        case 20: System.out.println(\"20\");break;\n" + "        case 30: System.out.println(\"30\");break;\n" + "        default:System.out.println(\"Not in 10, 20 or 30\");\n" + "ekranda nima chiqadi\n", "20", "10","Not in 10, 20 or 30","Not in 10, 20 or 30"))
        data.add(Test(34,1, 6, "int number=30;\n" + "        switch(number){\n" + "        case 10: System.out.println(\"10\");break;\n" + "        case 20: System.out.println(\"20\");break;\n" + "        case 30: System.out.println(\"30\");break;\n" + "        default:System.out.println(\"Not in 10, 20 or 30\");\n" + "ekranda nima chiqadi\n", "20", "30", "Not in 10, 20 or 30","30"))
        data.add(Test(35,1, 6, "int number=1;\n" + "        switch(number){\n" + "        case 1: System.out.println(\"1\");break;\n" + "        case 2: System.out.println(\"2\");break;\n" + "        case 3: System.out.println(\"3\");break;\n" + "        default:System.out.println(\"Not in 10, 20 or 30\");\n" + "ekranda nima chiqadi\n", "2", "1","","Not in 10, 20 or 30"))
        data.add(Test(36,1, 6, "int number=2;\n" + "        switch(number){\n" + "        case 1: System.out.println(\"10\");break;\n" + "        case 2: System.out.println(\"20\");break;\n" + "        case 30: System.out.println(\"30\");break;\n" + "        default:System.out.println(\"Not in 10, 20 or 30\");\n" + "ekranda nima chiqadi\n", "2", "10","Not in 10, 20 or 30","2"))
        data.add(Test(37,1, 7, "javada necha xil sikl operatori mavjud", "2", "3","4","3"))
        data.add(Test(38,1, 7, "for qanday operator", "shart", "sikl","tanlash","sikl"))
        data.add(Test(39,1, 7, "1 dan 100 gacha bo’lgan sonlar yigindisi berilgan tugri kodni toping", "for(int i=1; i<=100; i++){ s+=i;}", "for(int i=1; i<100; i++){ s-=i;}","for(int i=1; i<100; i++){ s+=i;}","for(int i=1; i<=100; i++){ s+=i;}"))
        data.add(Test(40,1, 7, "1 dan  50 gacha sonlar ko’paytmasi berilgan to’g’ri kodni toping", "for(int i=1; i<50; i++){ s+=i;}", "for(int i=1; i<50; i++){ s+=i;}","for(int i=1; i<=50; i++){ s*=i;}","for(int i=1; i<=50; i++){ s*=i;}"))
        data.add(Test(41,1, 7, "1 dan  100 gacha sonlar ko’paytmasi berilgan to’g’ri kodni toping", "for(int i=1; i<100; i++){ s+=i;}", "for(int i=1; i<=100; i++){ s*=i;}","for(int i=1; i<100; i++){ s*=i;}","for(int i=1; i<=100; i++){ s*=i;}"))
        data.add(Test(42,1, 7, "sikl takrorlanish davomida bajarilishi lozim bo’lgan operatorlar majmuasi nima deyiladi", "sikl boshi", "sikl oxiri","sikl tanasi","sikl tanasi"))
        data.add(Test(43,1, 7, "for(int i=0; i<10; i+=2)\n" +
                "Siklda ‘I’  nechtaga ko’payadi\n", "1", "2","3","2"))


        data.add(Test(44,1, 8, "i=0;\n" +
                "while(i<4){\n" +
                "if(i%2==0)\n" +
                "{System.out.println(i+” “)}\n" +
                "I++}\n" +
                "Ekranda nima chiqadi\n", "1", "2","3","2"))
        data.add(Test(45,1, 8, "i=0;\n" +
                "while(i<4){\n" +
                "if(i%2==1)\n" +
                "{System.out.println(i+” “)}\n" +
                "I++}\n" +
                "Ekranda nima chiqadi\n", "1,3", "2,3","3","1,3"))
        data.add(Test(46,1, 8, "i=0;\n" +
                "while(i<=4){\n" +
                "if(i%2==0)\n" +
                "{System.out.println(i+” “)}\n" +
                "I++}\n" +
                "Ekranda nima chiqadi\n", "1,4", "2,4","3,4","2,4"))
        data.add(Test(47,1, 8, "i=0;\n" +
                "while(i<=4){\n" +
                "if(i%3==0)\n" +
                "{System.out.println(i+” “)}\n" +
                "I++}\n" +
                "Ekranda nima chiqadi\n", "1,4", "2,4","3","3"))
        data.add(Test(48,1, 8, "i=1;\n" +
                "while(i<=14){\n" +
                "if(i%5==0)\n" +
                "{System.out.println(i+” “)}\n" +
                "I++}\n" +
                "Ekranda nima chiqadi\n", "1,4,5,6", "5,10","5,10,14","5,10"))
        data.add(Test(49,1, 8, "i=5;\n" +
                "while(i<=6){\n" +
                "if(i%2==0)\n" +
                "{System.out.println(i+” “)}\n" +
                "I++}\n" +
                "Ekranda nima chiqadi\n", "6", "2,4","6,2","6"))
        data.add(Test(50,1, 8, "i=1;\n" +
                "while(i<=4){\n" +
                "\n" +
                "System.out.println(i+” “)\n" +
                "I++}\n" +
                "Ekranda nima chiqadi\n", "1,4", "1,3,2,4","3,4,1","1,3,2,4"))

        data.add(Test(51,2, 1,"OOP nima ?",
            "Obyektga yo'naltirilgan dasturlash",
            "Obyektga qarshi dasturlash",
            "Obekt","Obyektga yo'naltirilgan dasturlash"))
        data.add(Test(52,2,  1,"Obekt tushunchasi ?",
            "javada o‘zgaruvchi",
            "Javada classdan olingan o’zgaruvchi",
            "bilmayman","Javada classdan olingan o’zgaruvchi"))

        data.add(Test(53,2,  1,"OOP asosiy ustunlari qaysilar",
            "Poliformism,Merosxorlik, Enkapsulatsiya",
            "Poliformism,massiv,Merosxorlik",
            "Merosxorlik,Funksiya,class","Poliformism,Merosxorlik, Enkapsulatsiya"))

        data.add(Test(54,2,  2,"public class Main {\n" +
                "            int x;\n" +
                "\n" +
                "            public static void main(String[] args) {\n" +
                "                Main myObj = new Main();\n" +
                "                myObj.x = 40;\n" +
                "                System.out.println(myObj.x);\n" +
                "            }\n" +
                "        }\n" +
                "        Bunda attirbut qaysi?", "myObj", "x", "Main","x"))
        data.add(Test(55,2,  2,"public class Main {\n" +
                "            int y;\n" +
                "\n" +
                "            public static void main(String[] args) {\n" +
                "                Main myObj = new Main();\n" +
                "                myObj.y = 40;\n" +
                "                System.out.println(myObj.y);\n" +
                "            }\n" +
                "        }\n" +
                "        Bunda attirbut qaysi?", "myObj", "y", "Main","y"))
        data.add(Test(56,2,  2,"public class Main {\n" +
                "            int z;\n" +
                "\n" +
                "            public static void main(String[] args) {\n" +
                "                Main myObj = new Main();\n" +
                "                myObj.z = 40;\n" +
                "                System.out.println(myObj.z);\n" +
                "            }\n" +
                "        }\n" +
                "        Bunda attirbut qaysi?", "myObj", "z", "Main","z"))
        data.add(Test(57,2,  3,"Constuctor nima?", "class nomidagi funksiya", "Massiv", "class nomidagi method","class nomidagi funksiya"))
        data.add(Test(58,2,  3,"Constuctor necha xil turi mavjud", "1", "2", "3","2"))
        data.add(Test(59,2,  3,"Javada konstruktor yaratish qoidalari:", "xoxlagan nom bilan yaratish mumkin", "boshqa funksiyalar bilan bir xil bo’lishi kerak", "class nomi bilan bir xil bo’lishi kerak","class nomi bilan bir xil bo’lishi kerak"))
        data.add(Test(60,2,  3,"Constuctor 2 turi bular qaysilar..", "Argumentli,funksiyali", "methodli,argumentsiz", "Argumentsiz konstruktorlar, Parametrlik konstruktorlar","Argumentsiz konstruktorlar, Parametrlik konstruktorlar"))
        data.add(Test(61,2,  3,"bu yerda consuctor qaysi?\n" +
                "        1.\t class Bike1 {\n" +
                "            2.\n" +
                "            3.\tBike1() {\n" +
                "                4.\tSystem.out.println(\"Bike is created\");\n" +
                "                5.\t}\n" +
                "            6.\n" +
                "            7.\tpublic static void main(String args[]) {\n" +
                "                8.\n" +
                "                9.\tBike1 b = new Bike1();\n" +
                "                10.\n" +
                "                11.\t}\n" +
                "            12.\n" +
                "        }", "B", "Bike1", "Bike","Bike1"))
        data.add(Test(62,2,  3,"Constuctor majburiy bo’lishi mumkinmi ?", "xa", "yuq", "classga bogliq","xa"))
        data.add(Test(63,2,  3,"Constuctor qiymat qabul qiladimi?", "ha", "yuq", "hammasi tugri","ha"))

        data.add(Test(64,2,  4,"Java-da inkapsulatsiya – bu?", "ma'lumotlar (o'zgaruvchilar) va ma'lumotlarga (usullarga) ta'sir qiluvchi kodni bir butunga birlashtirish mexanizmi", "belgilar va ma'lumotlarga (usullarga) ta'sir qiluvchi kodni bir butunga birlashtirish mexanizmi", "ma'lumotlarga (usullarga) ta'sir qiluvchi kodni bir butunga birlashtirish mexanizmi","ma'lumotlar (o'zgaruvchilar) va ma'lumotlarga (usullarga) ta'sir qiluvchi kodni bir butunga birlashtirish mexanizmi"))
        data.add(Test(65,2,  4,"Javada inkapsulatsiya qaysilar", "private,massiv", "private,public,protected", "public,method,protected","private,public,protected"))
        data.add(Test(66,2,  4,"public vazifasi nima?", "malumotlarni ochiq holda hamma foydalanishini kafolatlaydi", "Malumotlarni yopiq olda hech kim foydalana olmasligini kafolatlaydi", "malum bir yopiq va malum bir yopiq holda kafolatlaydi","malumotlarni ochiq holda hamma foydalanishini kafolatlaydi"))
        data.add(Test(67,2,  4,"private vazifasi nima?", "malumotlarni ochiq holda hamma foydalanishini kafolatlaydi", "Malumotlarni yopiq olda hech kim foydalana olmasligini kafolatlaydi", "malum bir yopiq va malum bir yopiq holda kafolatlaydi","Malumotlarni yopiq olda hech kim foydalana olmasligini kafolatlaydi"))
        data.add(Test(68,2,  4,"protected vazifasi nima?", "malumotlarni ochiq holda hamma foydalanishini kafolatlaydi", "Malumotlarni yopiq olda hech kim foydalana olmasligini kafolatlaydi", "malum bir yopiq va malum bir yopiq holda kafolatlaydi","malum bir yopiq va malum bir yopiq holda kafolatlaydi"))
        data.add(Test(69,2,  4,"Public classlarda ishlatiladimi ?", "xa", "yuq", "bilmayman","xa"))
        data.add(Test(70,2,  4,"Protected classlarda ishlatiladimi ?", "xa", "yuq", "bilmayman","xa"))

        data.add(Test(71,2,  5,"Metodni bekor qilish to'g'rik ko'rsatilgan javobni korsating", "Argumentlar ro'yxati bekor qilingan usul bilan bir xil bo'lishi kerak.", "Argumentlar ro'yxati bekor qilingan usul bilan xar xil bo'lishi kerak.", "Argumentlar ro'yxati bekor qilingan usul bilan ozgina xil bo'lishi kerak.","Argumentlar ro'yxati bekor qilingan usul bilan bir xil bo'lishi kerak."))
        data.add(Test(72,2,  5,"Metodni bekor qilish to'g'rik ko'rsatilgan javobni korsating", "Qaytish turi bir xil yoki superklassda asl bekor qilingan usulda e'lon qilingan qaytish turining pastki turi bo'lishi kerak.", "Argumentlar ro'yxati bekor qilingan usul bilan xar xil bo'lishi kerak.", "Argumentlar ro'yxati bekor qilingan usul bilan ozgina xil bo'lishi kerak.","Qaytish turi bir xil yoki superklassda asl bekor qilingan usulda e'lon qilingan qaytish turining pastki turi bo'lishi kerak."))
        data.add(Test(73,2,  5,"Ortiqcha usulning superklass versiyasini chaqirishda qanday kalit s’zdan foydalaniladi", "final", "super", "switch","super"))
        data.add(Test(74,2,  5,"class Animal {\n" +
                "            public void move() {\n" +
                "                System.out.println(\"Animals can move\");\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        class Dog extends Animal {\n" +
                "            public void move() {\n" +
                "                super.move();   // invokes the super class method\n" +
                "                System.out.println(\"Dogs can walk and run\");\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        public class TestDog {\n" +
                "\n" +
                "            public static void main(String args[]) {\n" +
                "                Animal b = new Dog();   // Animal reference but Dog object\n" +
                "                b.move();   // runs the method in Dog class\n" +
                "            }\n" +
                "        }\n" +
                "        Ekranga nima chiqadi", "Animals can move\n" +
                "        Dogs can walk and run", "move", "Dogs can walk and run","Animals can move\n" +
                "        Dogs can walk and run"))
        data.add(Test(75,2,  5,"Metodni bekor qilish qoidalarida konstructorni bekor qilish mumkinmi ?", "yuq", "xa", "bilmadim","yuq"))
        data.add(Test(76,2,  5,"Metodni bekor qilish qoidalarida Final deb e'lon qilingan usulni bekor qilib bo’ladimi", "xa", "yuq", "bilmayman","yuq"))
        data.add(Test(77,2,  5,"Metodni bekor qilish qoidalarida Boshqa paketdagi subklass faqat ommaviy yoki himoyalangan deb e'lon qilingan yakuniy bo'lmagan usullarni bekor qilishi mumkinmi.", "Xa", "yuq", "bilmayman","Xa"))


        data.add(Test(78,2, 6,"OOP nima ?",
            "Obyektga yo'naltirilgan dasturlash",
            "Obyektga qarshi dasturlash",
            "Obekt","Obyektga yo'naltirilgan dasturlash"))
        data.add(Test(79,2,  6,"Obekt tushunchasi ?",
            "javada o‘zgaruvchi",
            "Javada classdan olingan o’zgaruvchi",
            "bilmayman","Javada classdan olingan o’zgaruvchi"))

        data.add(Test(53,2,  6,"OOP asosiy ustunlari qaysilar",
            "Poliformism,Merosxorlik, Enkapsulatsiya",
            "Poliformism,massiv,Merosxorlik",
            "Merosxorlik,Funksiya,class","Poliformism,Merosxorlik, Enkapsulatsiya"))

        data.add(Test(80,2,  7,"public class Main {\n" +
                "            int x;\n" +
                "\n" +
                "            public static void main(String[] args) {\n" +
                "                Main myObj = new Main();\n" +
                "                myObj.x = 40;\n" +
                "                System.out.println(myObj.x);\n" +
                "            }\n" +
                "        }\n" +
                "        Bunda attirbut qaysi?", "myObj", "x", "Main","x"))
        data.add(Test(81,2,  7,"public class Main {\n" +
                "            int y;\n" +
                "\n" +
                "            public static void main(String[] args) {\n" +
                "                Main myObj = new Main();\n" +
                "                myObj.y = 40;\n" +
                "                System.out.println(myObj.y);\n" +
                "            }\n" +
                "        }\n" +
                "        Bunda attirbut qaysi?", "myObj", "y", "Main","y"))
        data.add(Test(82,2,  7,"public class Main {\n" +
                "            int z;\n" +
                "\n" +
                "            public static void main(String[] args) {\n" +
                "                Main myObj = new Main();\n" +
                "                myObj.z = 40;\n" +
                "                System.out.println(myObj.z);\n" +
                "            }\n" +
                "        }\n" +
                "        Bunda attirbut qaysi?", "myObj", "z", "Main","z"))
        data.add(Test(83,2,  8,"Constuctor nima?", "class nomidagi funksiya", "Massiv", "class nomidagi method","class nomidagi funksiya"))
        data.add(Test(84,2,  8,"Constuctor necha xil turi mavjud", "1", "2", "3","2"))
        data.add(Test(85,2,  8,"Javada konstruktor yaratish qoidalari:", "xoxlagan nom bilan yaratish mumkin", "boshqa funksiyalar bilan bir xil bo’lishi kerak", "class nomi bilan bir xil bo’lishi kerak","class nomi bilan bir xil bo’lishi kerak"))
        data.add(Test(86,2,  8,"Constuctor 2 turi bular qaysilar..", "Argumentli,funksiyali", "methodli,argumentsiz", "Argumentsiz konstruktorlar, Parametrlik konstruktorlar","Argumentsiz konstruktorlar, Parametrlik konstruktorlar"))
        data.add(Test(87,2,  8,"bu yerda consuctor qaysi?\n" +
                "        1.\t class Bike1 {\n" +
                "            2.\n" +
                "            3.\tBike1() {\n" +
                "                4.\tSystem.out.println(\"Bike is created\");\n" +
                "                5.\t}\n" +
                "            6.\n" +
                "            7.\tpublic static void main(String args[]) {\n" +
                "                8.\n" +
                "                9.\tBike1 b = new Bike1();\n" +
                "                10.\n" +
                "                11.\t}\n" +
                "            12.\n" +
                "        }", "B", "Bike1", "Bike","Bike1"))
        data.add(Test(88,2,  8,"Constuctor majburiy bo’lishi mumkinmi ?", "xa", "yuq", "classga bogliq","xa"))
        data.add(Test(89,2,  8,"Constuctor qiymat qabul qiladimi?", "ha", "yuq", "hammasi tugri","ha"))

        data.add(Test(90,2,  9,"Java-da inkapsulatsiya – bu?", "ma'lumotlar (o'zgaruvchilar) va ma'lumotlarga (usullarga) ta'sir qiluvchi kodni bir butunga birlashtirish mexanizmi", "belgilar va ma'lumotlarga (usullarga) ta'sir qiluvchi kodni bir butunga birlashtirish mexanizmi", "ma'lumotlarga (usullarga) ta'sir qiluvchi kodni bir butunga birlashtirish mexanizmi","ma'lumotlar (o'zgaruvchilar) va ma'lumotlarga (usullarga) ta'sir qiluvchi kodni bir butunga birlashtirish mexanizmi"))
        data.add(Test(91,2,  9,"Javada inkapsulatsiya qaysilar", "private,massiv", "private,public,protected", "public,method,protected","private,public,protected"))
        data.add(Test(92,2,  9,"public vazifasi nima?", "malumotlarni ochiq holda hamma foydalanishini kafolatlaydi", "Malumotlarni yopiq olda hech kim foydalana olmasligini kafolatlaydi", "malum bir yopiq va malum bir yopiq holda kafolatlaydi","malumotlarni ochiq holda hamma foydalanishini kafolatlaydi"))
        data.add(Test(93,2,  9,"private vazifasi nima?", "malumotlarni ochiq holda hamma foydalanishini kafolatlaydi", "Malumotlarni yopiq olda hech kim foydalana olmasligini kafolatlaydi", "malum bir yopiq va malum bir yopiq holda kafolatlaydi","Malumotlarni yopiq olda hech kim foydalana olmasligini kafolatlaydi"))
        data.add(Test(94,2,  9,"protected vazifasi nima?", "malumotlarni ochiq holda hamma foydalanishini kafolatlaydi", "Malumotlarni yopiq olda hech kim foydalana olmasligini kafolatlaydi", "malum bir yopiq va malum bir yopiq holda kafolatlaydi","malum bir yopiq va malum bir yopiq holda kafolatlaydi"))
        data.add(Test(95,2,  9,"Public classlarda ishlatiladimi ?", "xa", "yuq", "bilmayman","xa"))
        data.add(Test(96,2,  9,"Protected classlarda ishlatiladimi ?", "xa", "yuq", "bilmayman","xa"))

        data.add(Test(97,2,  10,"Metodni bekor qilish to'g'rik ko'rsatilgan javobni korsating", "Argumentlar ro'yxati bekor qilingan usul bilan bir xil bo'lishi kerak.", "Argumentlar ro'yxati bekor qilingan usul bilan xar xil bo'lishi kerak.", "Argumentlar ro'yxati bekor qilingan usul bilan ozgina xil bo'lishi kerak.","Argumentlar ro'yxati bekor qilingan usul bilan bir xil bo'lishi kerak."))
        data.add(Test(98,2,  10,"Metodni bekor qilish to'g'rik ko'rsatilgan javobni korsating", "Qaytish turi bir xil yoki superklassda asl bekor qilingan usulda e'lon qilingan qaytish turining pastki turi bo'lishi kerak.", "Argumentlar ro'yxati bekor qilingan usul bilan xar xil bo'lishi kerak.", "Argumentlar ro'yxati bekor qilingan usul bilan ozgina xil bo'lishi kerak.","Qaytish turi bir xil yoki superklassda asl bekor qilingan usulda e'lon qilingan qaytish turining pastki turi bo'lishi kerak."))
        data.add(Test(99,2,  10,"Ortiqcha usulning superklass versiyasini chaqirishda qanday kalit s’zdan foydalaniladi", "final", "super", "switch","super"))
        data.add(Test(100,2,  10,"class Animal {\n" +
                "            public void move() {\n" +
                "                System.out.println(\"Animals can move\");\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        class Dog extends Animal {\n" +
                "            public void move() {\n" +
                "                super.move();   // invokes the super class method\n" +
                "                System.out.println(\"Dogs can walk and run\");\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        public class TestDog {\n" +
                "\n" +
                "            public static void main(String args[]) {\n" +
                "                Animal b = new Dog();   // Animal reference but Dog object\n" +
                "                b.move();   // runs the method in Dog class\n" +
                "            }\n" +
                "        }\n" +
                "        Ekranga nima chiqadi", "Animals can move\n" +
                "        Dogs can walk and run", "move", "Dogs can walk and run","Animals can move\n" +
                "        Dogs can walk and run"))
        data.add(Test(101,2,  10,"Metodni bekor qilish qoidalarida konstructorni bekor qilish mumkinmi ?", "yuq", "xa", "bilmadim","yuq"))
        data.add(Test(102,2,  10,"Metodni bekor qilish qoidalarida Final deb e'lon qilingan usulni bekor qilib bo’ladimi", "xa", "yuq", "bilmayman","yuq"))
        data.add(Test(103,2,  10,"Metodni bekor qilish qoidalarida Boshqa paketdagi subklass faqat ommaviy yoki himoyalangan deb e'lon qilingan yakuniy bo'lmagan usullarni bekor qilishi mumkinmi.", "Xa", "yuq", "bilmayman","Xa"))

        data.add(Test(104,2,  11,"To’plamlar nima ?", "bu bo'sh jismlar bilan bog'liq usullarni guruhlash uchun ishlatiladigan to'liq \" mavhum sinf \":", "to’plamlar(collection’lar) framework bo’lib, u o’zida obyektlarni saqlaydi.", "to’plamlar(collection’lar) framework emas lekin o’zida obyektlarni saqlaydi.","to’plamlar(collection’lar) framework bo’lib, u o’zida obyektlarni saqlaydi."))
        data.add(Test(105,2,  11,"To’plamlarda qanday jarayonlarni amalga oshirsa bo’ladi", "qidirish", "qidirish,saralash,yozish,o’chirish", "saralash,o’chirish","qidirish,saralash,yozish,o’chirish"))
        data.add(Test(106,2,  11,"To’plamlar qanday interfacelardan tashkil topgan", "qidirish,to’plash", "Set, List, Queue, Deque", "ArrayList, Vector, LinkedList, PriorityQueue, HashSet","Set, List, Queue, Deque"))
        data.add(Test(107,2,  11,"To’plamlar qanday classlardan tashkil topgan", "qidirish,to’plash", "Set, List, Queue, Deque", "ArrayList, Vector, LinkedList, PriorityQueue, HashSet","ArrayList, Vector, LinkedList, PriorityQueue, HashSet"))
        data.add(Test(108,2,  11,"To’plamlar qaysi paketda saqlanadi", "java.util", "java.src", "java.list","java.util"))
        data.add(Test(109,2,  11,"Iterator va ListIteratorlardan qanday foydalaniladi?", "to’plamlarning elementlarini qaytarishda foydalaniladi", "to’plamlar(collection’lar) framework bo’lib, u o’zida obyektlarni saqlashda", "bu bo'sh jismlar bilan bog'liq usullarni guruhlash uchun ishlatishda","to’plamlar(collection’lar) framework bo’lib, u o’zida obyektlarni saqlashda"))
        data.add(Test(110,2,  11,"public boolean add(Object element) nima vazifani bajaradi", "To’plamga ma’lumot yizishda foydalanilari", "To’plamga ma’lumot uchrishda foydalanilari", "To’plamni bo’sh yokiy bo’sh emasligiga tekshiradi","To’plamga ma’lumot yizishda foydalanilari"))



        return data
    }
    override fun showError(s: String) {
        toast(s)
    }

}