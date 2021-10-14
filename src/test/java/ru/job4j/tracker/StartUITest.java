package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ====" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenShowAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(new String[]{
                "0", "test1", "0", "test2", "1", "2"
        });
        UserAction[] actions = new UserAction[]{
                new CreateAction(out),
                new ShowAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Exit Program" + ln
                        + "=== Create a new Item ====" + ln
                        + "Добавленная заявка: " + tracker.findById(1) + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Exit Program" + ln
                        + "=== Create a new Item ====" + ln
                        + "Добавленная заявка: " + tracker.findById(2) + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Exit Program" + ln
                        + "=== Show all items ====" + ln
                        + tracker.findById(1) + ln
                        + tracker.findById(2) + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(new String[]{
                "0", "test1", "0", "test2", "1", "1", "1", "3", "2"
        });
        UserAction[] actions = new UserAction[]{
                new CreateAction(out),
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Find item by id" + ln
                        + "2. Exit Program" + ln
                        + "=== Create a new Item ====" + ln
                        + "Добавленная заявка: " + tracker.findById(1) + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Find item by id" + ln
                        + "2. Exit Program" + ln
                        + "=== Create a new Item ====" + ln
                        + "Добавленная заявка: " + tracker.findById(2) + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Find item by id" + ln
                        + "2. Exit Program" + ln
                        + "=== Find item by id ====" + ln
                        + tracker.findById(1) + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Find item by id" + ln
                        + "2. Exit Program" + ln
                        + "=== Find item by id ====" + ln
                        + "Заявка с введенным id: " + "3" + " не найдена." + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Find item by id" + ln
                        + "2. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(new String[]{
                "0", "test1", "0", "test2", "1", "test1", "1", "test3", "2"
        });
        UserAction[] actions = new UserAction[]{
                new CreateAction(out),
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Find items by name" + ln
                        + "2. Exit Program" + ln
                        + "=== Create a new Item ====" + ln
                        + "Добавленная заявка: " + tracker.findById(1) + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Find items by name" + ln
                        + "2. Exit Program" + ln
                        + "=== Create a new Item ====" + ln
                        + "Добавленная заявка: " + tracker.findById(2) + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Find items by name" + ln
                        + "2. Exit Program" + ln
                        + "=== Find items by name ====" + ln
                        + tracker.findById(1) + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Find items by name" + ln
                        + "2. Exit Program" + ln
                        + "=== Find items by name ====" + ln
                        + "Заявки с именем: " + "test3" + " не найдены." + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Find items by name" + ln
                        + "2. Exit Program" + ln
        ));
    }
}