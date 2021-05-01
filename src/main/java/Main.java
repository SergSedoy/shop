import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Программа: М А Г А З и Н.");
// принцип разделения интерфейса I -> при написании программы создан набор различных разделённых интерфейсов FilterId, FilterName, FilterManuf
// вместо одного большого.
        Scanner scanner = new Scanner(System.in);
        Products products = new Products();// принцип единственной ответственности S -> класс выполняет только функции базы данных товаров магазина
        products.fill();
        Basket basket = new Basket(); // принцип единственной ответственности S -> класс 'корзина' выполняет только функции корзины магазина
        Order order = new Order(); // принцип единственной ответственности S -> класс 'заказы' выполняет только функции работы с заказами магазина
        int count = 1;
        while (true) {
            System.out.println("М Е Н Ю:" +
                    "\n 1. Список товаров" +
                    "\n 2. Поиск товара" +
                    "\n 3. Корзина" +
                    "\n 4. Мои заказы" +
                    "\n 5. Выход" +
                    "\n -----------------------------" +
                    "\n Выберите пункт из меню (1-5):");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 5) {
                System.out.println("До новых встреч!!!");
                break;
            }
            switch (choice) {
                case 1:
                    products.print(); // принцип замены Барбары Лисков L -> у классов 'Products' 'Order' и 'Basket' есть метод print(), с точки зрения наследования они
                    //никак не связаны, и не могут являться наследником или предком друг друга.
                    while (true) {
                        System.out.println("Положить товар в корзину (введите id товара и количество) или введите `end`");
                        String input = scanner.nextLine();
                        if (input.equals("end"))
                            break;
                        String[] listData = input.split(" ");
                        basket.basketPut(listData[0], Integer.parseInt(listData[1]));
                    }
                    break;
                case 2:
                    System.out.println("Поиск товара:" +
                            "\n 1. поиск по id" +
                            "\n 2. поиск по производителю и наименованию" +
                            "\n 3. поиск по наименованию" +
                            "\n 4. Выход" +
                            "\n -----------------------------" +
                            "\n Выберите пункт из меню (1-4):");
                    int choiceFilter = scanner.nextInt();
                    scanner.nextLine();
                    if (choiceFilter == 4)
                        break;
                    if (choiceFilter == 3) {
                        System.out.println("Введите наименование товара");
                        String name = scanner.nextLine();
                        new SearchName(products.getProductsBase()).filterName(name);
                    }

                    if (choiceFilter == 2) {
                        System.out.println("Введите производителя товара");
                        String manufacturer = scanner.nextLine();
                        System.out.println("Введите наименование товара");
                        String name = scanner.nextLine();
                        SearchManName search = new SearchManName(products.getProductsBase());
                        search.filterManufacturer(manufacturer);
                        search.filterName(name);
                    }

                    if (choiceFilter == 1) {
                        System.out.println("Введите id товара");
                        String id = scanner.nextLine();
                        new SearchId(products.getProductsBase()).filterId(id);// принцип инверсии зависимостей D
                    }

                    break;
                case 3:

                    if (basket.getBasketProduct().isEmpty())
                        System.out.println("Ваша корзина пуста!");
                    else {
                        System.out.println("В корзине товары: ");
                        basket.print(products); // принцип 'DRY' -> повторяющийся код для печати списка товаров в корзине вынесен в метод
                        while (true) {
                            System.out.println("Меню корзины:" +
                                    "\n 1. Удалить товар из корзины" +
                                    "\n 2. Оформить заказ" +
                                    "\n 3. Выход" +
                                    "\n -----------------------------" +
                                    "\n Выберите пункт из меню (1-3):");
                            int choiceBasket = scanner.nextInt();
                            scanner.nextLine();

                            if (choiceBasket == 1) {
                                while (true) {
                                    System.out.println("Удалить товар из корзины (введите id товара) или введите `end`");
                                    String input = scanner.nextLine();
                                    if (input.equals("end"))
                                        break;
                                    basket.basketRemove(input);
                                }
                                basket.print(products); // принцип 'DRY' -> повторяющийся код для печати списка товаров в корзине вынесен в метод
                            }

                            if (choiceBasket == 2) {
                                order.listOrders(basket.getBasketProduct(), products);
                                System.out.println("Заказ оформлен! Номер заказа " + count);
                                count++;
                                basket.getBasketProduct().clear();
                            }

                            if (choiceBasket == 3)
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Мои заказы:");
                    order.print();
                    break;
            }

        }
        scanner.close();
    }
}

// Вывод доступных для покупки товаров
// Фильтрация товаров по ключевым словам, ценам, производителям
// Составление продуктовой корзины пользователя
// Трекинг заказа в системе доставки
// Возврат заказа, повтороение заказа
// Система рейтинга для товаров
// Простая рекомендательная система для покупок
