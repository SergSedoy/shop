import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Программа: М А Г А З И Н.");
        Scanner scanner = new Scanner(System.in);
        Products products = new Products();
        products.fill();
        Basket basket = new Basket();
        Order order = new Order();

        //MissedCalls missedCalls = new MissedCalls();
        while (true) {
            System.out.println("М Е Н Ю:" +
                    "\n 1. Список товаров" +
                    "\n 2. Поиск товара" +
                    "\n 3. Корзина" +
                    "\n 4. Трекинг заказа" +
                    "\n 5. Мои заказы" +
                    "\n 6. Выход" +
                    "\n -----------------------------" +
                    "\n Выберите пункт из меню (1-6):");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 6) {
                System.out.println("До новых встреч!!!");
                break;
            }
            switch (choice) {
                case 1:
                    products.printProductsBase();
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
                    System.out.println("Поиск товара (введите id товара)");
                    // String phoneData = scanner.nextLine();
                    // contacts.searchContact(phoneData);
                    break;
                case 3:
                    if (basket.getBasketProduct().isEmpty())
                        System.out.println("Ваша корзина пуста!");
                    else {
                        System.out.println("В корзине товары: ");
                        basket.printBascetPut(products);
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
                                basket.printBascetPut(products);
                            }

                            if (choiceBasket == 2) {
                                System.out.println("Заказ оформлен!");
                            }
                        }
                    }
                        break;
                        // case 4:
                        //     System.out.println("Добавьте номер пропущенного вызова");
                        //     String numberPhone = scanner.nextLine();
                        //     missedCalls.addMissedCall(numberPhone);
                        //     break;
                        // case 5:
                        //     System.out.println("Список пропущенных вызовов:");
                        //     missedCalls.printX(contacts);
                        //     break;
                        // case 6:
                        // missedCalls.clear();
                        // break;
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
