package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupDeletionTests extends TestBase {

    // Создание группы, если группа отсутствует.
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test2name").withHeader("test2header").withFooter("test2footer"));
        }
    }

    @Test
    public void testGroupDeletion() {
        app.goTo().groupPage();
        Groups before = app.db().groups();
        GroupData deletingGroup = before.iterator().next();

        app.group().delete(deletingGroup);
        app.goTo().groupPage();
        assertThat(app.group().count(), equalTo(before.size() - 1));

        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(deletingGroup)));
        verifyGroupListInUI();
    }


}