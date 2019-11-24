package specialtasks.collections.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyList list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList();
    }

    @Nested
    class EmptyListTest {

        @Test
        void size_EmptyList_Success() {
            assertEquals(0, list.size());
        }

        @Test
        void add_OneElement_Success() {
            String s = "one";

            list.add(s);

            assertEquals(1, list.size());
            assertEquals(s, list.get(0));
        }

        @Test
        void add_InsertElement_ExceptionThrown() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "hello"));
        }

        @Test
        void add_InsertElementInImpossiblePosition_ExceptionThrown() {
            assertThrows(IndexOutOfBoundsException.class, () -> {
                String s = "nothing";
                Random random = new Random(47);
                int index = random.nextInt(100) + 100;
                list.add(index, s);
            });
        }

        @Test
        void add_InsertElementInImpossibleMinusPosition_ExceptionThrown() {
            assertThrows(IndexOutOfBoundsException.class, () -> {
                String s = "nothing";
                int index = -1;
                list.add(index, s);
            });
        }

        @Test
        void set_ChangeElementOnImpossiblePosition_ExceptionThrown() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "nothing"));
        }

        @Test
        void get_GetFromEmptyList_ExceptionThrown() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        }

        @Test
        void remove_RemoveFromEmptyList_ExceptionThrown() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        }

    }

    @Nested
    class ListWithRandomElementsTest {

        private static final int SIZE = 15;
        private static final String someElement = "element";
        private final String FIRST_EL = "first";
        private final String LAST_EL = "last";

        @BeforeEach
        void init() {
            list.add(FIRST_EL);

            for (int i = 0, n = SIZE - 2; i < n; i++) {
                list.add(Integer.toString(i));
            }

            list.add(LAST_EL);
        }

        @Nested
        class AddTest {

            @Test
            void add_UnderTenElements_Success() {
                assertEquals(SIZE, list.size());

                assertEquals(FIRST_EL, list.get(0));

                for (int i = 1, n = SIZE - 1; i < n; i++) {
                    assertEquals(Integer.toString(i - 1), list.get(i));
                }

                assertEquals(LAST_EL, list.get(SIZE - 1));
            }

            @Test
            void add_InsertElementInFirstPosition_Success() {
                String s = "zero";
                int index = 0;
                list.add(index, s);

                assertEquals(SIZE + 1, list.size());
                assertEquals(s, list.get(index));
            }

            @Test
            void add_InsertElementInLastPosition_Success() {
                String s = "zero";
                list.add(SIZE, s);

                assertEquals(SIZE + 1, list.size());
                assertEquals(s, list.get(SIZE));
            }

            @Test
            void add_InsertElementInMiddlePosition_Success() {
                String s = "zero";
                int index = SIZE / 2;
                list.add(index, s);

                assertEquals(SIZE + 1, list.size());
                assertEquals(s, list.get(index));
            }

        }

        @Nested
        class SetTest {

            @Test
            void set_ChangeElementInFilledListOnImpossiblePosition_ExceptionThrown() {
                int index = SIZE + 100;
                assertThrows(IndexOutOfBoundsException.class, () -> list.set(index, someElement));
            }

            @Test
            void set_ChangeFirstElement_Success() {
                int index = 0;
                list.set(index, someElement);

                assertEquals(SIZE, list.size());
                assertEquals(someElement, list.get(index));
            }

            @Test
            void set_ChangeLastElement_Success() {
                int index = SIZE - 1;
                list.set(index, someElement);


                assertEquals(SIZE, list.size());
                assertEquals(someElement, list.get(index));
            }

            @Test
            void set_ChangeInMiddleElement_Success() {
                int index = SIZE / 2;
                list.set(index, someElement);


                assertEquals(SIZE, list.size());
                assertEquals(someElement, list.get(index));
            }

        }

        @Nested
        class GetTest {

            @Test
            void get_GetImpossibleIndexElement_ExceptionThrown() {
                assertThrows(IndexOutOfBoundsException.class, () -> list.get(SIZE));
            }

            @Test
            void get_GetFirstElement_Success() {
                assertEquals(FIRST_EL, list.get(0));
            }

            @Test
            void get_GetLastElement_Success() {
                assertEquals(LAST_EL, list.get(SIZE - 1));
            }

            @Test
            void get_InMiddle_Success() {
                int index = SIZE / 2;
                list.add(index, someElement);

                assertEquals(someElement, list.get(index));
            }

        }

        @Nested
        class RemoveTest {

            @Test
            void remove_IndexOut_ExceptionThrown() {
                assertThrows(IndexOutOfBoundsException.class, () -> list.remove(SIZE));
            }

            @Test
            void remove_NonExistElement_Failed() {
                String el = "";
                assertFalse(list.remove(el));
            }

            @Test
            void remove_FirstElementByIndex_Success() {
                assertEquals(FIRST_EL, list.remove(0));
                //assertEquals(SIZE - 1, list.size());
            }

            @Test
            void remove_FirstElementByValue_Success() {
                assertTrue(list.remove(FIRST_EL));
                assertEquals(SIZE - 1, list.size());
            }

            @Test
            void remove_LastElementByIndex_Success() {
                assertEquals(FIRST_EL, list.remove(0));
                assertEquals(SIZE - 1, list.size());
            }

            @Test
            void remove_LastElementByValue_Success() {
                assertTrue(list.remove(FIRST_EL));
                assertEquals(SIZE - 1, list.size());
            }

            @Nested
            class MiddleElementTest {

                private static final String MIDDLE = "middle";
                private static final int MIDDLE_INDEX = SIZE / 2;

                @BeforeEach
                void init() {
                    list.add(MIDDLE_INDEX, MIDDLE);
                }

                @Test
                void remove_MiddleElementByIndex_Success() {
                    assertEquals(MIDDLE, list.remove(MIDDLE_INDEX));
                    assertEquals(SIZE, list.size());
                }

                @Test
                void remove_MiddleElementByValue_Success() {
                    assertTrue(list.remove(MIDDLE));
                    assertEquals(SIZE, list.size());
                }

            }

        }

        @Nested
        class ContainsTest {

            @Test
            void contains_ContainsNonExistElement_Failed() {
                String el = "";
                assertFalse(list.contains(el));
            }

            @Test
            void contains_FirstElement_Success() {
                assertTrue(list.contains(FIRST_EL));
            }

            @Test
            void contains_LastElement_Success() {
                assertTrue(list.contains(LAST_EL));
            }

        }

        @Nested
        class GetIndexByValueTest {

            private static final int NON_EXIST = -1;
            private static final int SIZE = ListWithRandomElementsTest.SIZE + 2;
            private static final String ELEMENT = "element";
            private static final int FIRST_POSITION = 2;
            private static final int LAST_POSITION = SIZE - 2;

            @BeforeEach
            void init() {
                list.add(FIRST_POSITION, ELEMENT);
                list.add(LAST_POSITION, ELEMENT);
            }

            @Test
            void indexOf_NonExistElement_Failed() {
                String el = "";
                assertEquals(NON_EXIST, list.indexOf(el));
            }

            @Test
            void lastIndexOf_NonExistElement_Failed() {
                String el = "";
                assertEquals(NON_EXIST, list.lastIndexOf(el));
            }

            @Test
            void indexOf_FirstElement_Success() {
                assertEquals(FIRST_POSITION, list.indexOf(ELEMENT));
            }


            @Test
            void lastIndexOf_FirstElement_Success() {
                assertEquals(LAST_POSITION, list.lastIndexOf(ELEMENT));
            }

        }

        @Test
        void clear_NotEmptyList_Success() {
            list.clear();
            assertEquals(0, list.size());
        }

    }

    @Nested
    class ClearTest {

        @Test
        void clear_EmptyClear_Success() {
            list.clear();
        }

    }

}