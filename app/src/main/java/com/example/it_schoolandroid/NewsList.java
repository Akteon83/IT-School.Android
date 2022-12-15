package com.example.it_schoolandroid;

public class NewsList {

    private static final MyNews news_1 = new MyNews("Никола Питерский - тогда и сейчас",
            "Российские историки восстановили фотографии знаменитого советского бандита - Николы Питерского", R.drawable.ivan1);
    private static final MyNews news_2 = new MyNews("МИД РФ назвал главные причины конфликта на Украине",
            "Официальный представитель МИД РФ Мария Захарова в своем брифинге обра... ПРИЛОЖЕНИЕ НЕ ПОДЕРЖИВАЕТ ПОЛИТИЧЕСКИЕ НОВОСТИ", R.drawable.zaharova);
    private static final MyNews news_3 = new MyNews("Улыбайся чаще - последние исследования",
            "Австрийские ученые подтвердили тот факт, что улыбка делает людей лучше. Группой исследователей заставляла ребенка улыбаться на камеру, и, спустя несколько лет, он добился огромных высот и уже преподает в IT-школе Samsung", R.drawable.ivan2);
    private static final MyNews news_4 = new MyNews("Трагедия в Краснодарском крае: школьник попал под поезд",
            "В районе города Курганинска во время прибытия поезда ребенок школьного возраста оказался на железнодорожных путях. К счастью, катастрофы удалось избежать, потому что вовремя спохватившийся машинист сумел заставить поезд перепрыгнуть мальчика.", R.drawable.img);
    private static final MyNews news_5 = new MyNews("Never gonna give you up", "Never gonna let you down", R.drawable.img_1);
    private static final MyNews news_6 = new MyNews("Изменение политики российских авиакомпаний",
            "В связи с критической нехваткой среднемагистральных самолетов, компанией Аэрофлот было принято решение перейти на более доступный вариант - пополнение авиапарков многоцелевыми двухместными истребителями Су-30СМ2. Билет на такой рейс будет стоить в разы дороже, но впечатления останутся на всю жизнь.", R.drawable.su_30);

    public static final MyNews[] newsList = {news_1, news_2, news_3, news_4, news_5, news_6};
}
