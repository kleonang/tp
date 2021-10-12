package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_PREAMBLE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STUDENT_LETTER;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTOR_LETTER;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteCommand;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class DeleteCommandParserTest {

    private DeleteCommandParser parser = new DeleteCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        Index targetIndex = INDEX_FIRST_PERSON;
        String validIndex = " " + targetIndex.getOneBased();
        assertParseSuccess(parser, VALID_TUTOR_LETTER + validIndex,
                new DeleteCommand(INDEX_FIRST_PERSON, PersonType.TUTOR));
        assertParseSuccess(parser, VALID_STUDENT_LETTER + validIndex,
                new DeleteCommand(INDEX_FIRST_PERSON, PersonType.STUDENT));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, INVALID_PREAMBLE, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteCommand.MESSAGE_USAGE));
    }
}
