package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

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
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = List.of(
                new EditAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(
                new DeleteAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = List.of(
                new EditAction(out),
                new ExitAction()
        );
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
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new String[]{
                "0", "1"
        });
        List<UserAction> actions = List.of(
                new ShowAllAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ====" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new String[]{
                "0", String.valueOf(one.getId()), "0", "3", "1"
        });
        List<UserAction> actions = List.of(
                new FindByIdAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ====" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ====" + ln
                        + "Заявка с введенным id: " + "3" + " не найдена." + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new String[]{
                "0", "test1", "0", "test3", "1"
        });
        List<UserAction> actions = List.of(
                new FindByNameAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ====" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ====" + ln
                        + "Заявки с именем: " + "test3" + " не найдены." + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2", "0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Exit Program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit Program" + ln
                )
        );
    }
}