package net.runelite.client.plugins.gpu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Reproduces (without any live game, GPU, or OpenGL context) the theory that when
 * {@code hiddenRoofIds} comes back empty for a floor above the player, the roof-culling
 * logic in Zone.renderOpaque falls back to drawing the WHOLE floor -- including roof
 * geometry that should have stayed hidden.
 *
 * NOTE ON APPROACH: Zone.renderOpaque itself ends with real OpenGL calls
 * (glUniform3i / glBindVertexArray / glMultiDrawArrays) and, on at least some
 * environments, touching those without a live GL context crashes the JVM natively
 * (EXCEPTION_ACCESS_VIOLATION in lwjgl_opengl.dll) rather than throwing a catchable
 * Java exception -- confirmed when running this locally. RuneLite's own GPU tests
 * (ShaderTest) avoid this entirely by never creating a real GL context either; they
 * shell out to an external validator instead.
 *
 * So instead of calling the real method, this test mirrors ONLY the range-selection
 * logic (Zone.java's renderOpaque, roughly lines 218-262 at the time of writing) as
 * plain Java, with no LWJGL import at all. This is a faithful line-for-line copy of
 * that logic, not a reimplementation from scratch -- if Zone.java's roof-culling
 * logic changes, this copy needs to be updated to match.
 */
public class ZoneRoofRemovalTest
{
    /**
     * Mirrors the per-level loop body inside Zone.renderOpaque. Returns the list of
     * [start, end) byte ranges that would be queued for drawing.
     */
    private static List<int[]> selectRanges(
            int[] levelOffsets, int[][] rids, int[][] roofStart, int[][] roofEnd,
            int minLevel, int currentLevel, int maxLevel, Set<Integer> hiddenRoofIds)
    {
        List<int[]> ranges = new ArrayList<>();

        for (int level = minLevel; level <= maxLevel; ++level)
        {
            int[] levelRids = rids[level];
            int[] levelRoofStart = roofStart[level];
            int[] levelRoofEnd = roofEnd[level];

            if (levelRids.length == 0 || hiddenRoofIds.isEmpty() || level <= currentLevel)
            {
                // draw the whole level
                int start = level == 0 ? 0 : levelOffsets[level - 1];
                int end = levelOffsets[level];
                if (start != end)
                {
                    ranges.add(new int[] { start, end });
                }
                continue;
            }

            for (int roofIdx = 0; roofIdx < levelRids.length; ++roofIdx)
            {
                int rid = levelRids[roofIdx];
                if (rid > 0 && !hiddenRoofIds.contains(rid))
                {
                    // draw the roof
                    if (levelRoofEnd[roofIdx] > levelRoofStart[roofIdx])
                    {
                        ranges.add(new int[] { levelRoofStart[roofIdx], levelRoofEnd[roofIdx] });
                    }
                }
            }

            // push from the end of the last roof to the end of the level
            int endpos = level == 0 ? 0 : levelOffsets[level - 1];
            for (int roofIdx = levelRids.length - 1; roofIdx >= 0; --roofIdx)
            {
                int rid = levelRids[roofIdx];
                if (rid > 0)
                {
                    endpos = levelRoofEnd[roofIdx];
                    break;
                }
            }
            if (endpos != levelOffsets[level])
            {
                ranges.add(new int[] { endpos, levelOffsets[level] });
            }
        }

        return ranges;
    }

    private static boolean isByteDrawn(List<int[]> ranges, int b)
    {
        for (int[] range : ranges)
        {
            if (b >= range[0] && b < range[1])
            {
                return true;
            }
        }
        return false;
    }

    // Shared fixture: two floors. Floor 0 is the player's own floor, bytes [0,150),
    // with no roof entries -- always drawn whole. Floor 1 (the floor ABOVE the
    // player) spans bytes [150,200), made of one roof piece (id 5) at [150,180)
    // followed by "everything else" on that floor at [180,200).
    private static final int[] LEVEL_OFFSETS = { 150, 200, 200, 200 };
    private static final int[][] RIDS = { {}, { 5 }, {}, {} };
    private static final int[][] ROOF_START = { {}, { 150 }, {}, {} };
    private static final int[][] ROOF_END = { {}, { 180 }, {}, {} };
    private static final int ROOF_BYTE = 160; // any byte inside [150,180)

    @Test
    public void roofIsHiddenWhenHiddenRoofIdsIsPopulated()
    {
        // currentLevel = 0 (player's floor), maxLevel = 1 (floor above).
        // hiddenRoofIds = {5}: roof removal correctly says "hide roof 5".
        List<int[]> ranges = selectRanges(
                LEVEL_OFFSETS, RIDS, ROOF_START, ROOF_END,
                0, 0, 1, Set.of(5));

        assertFalse("roof should be culled when hiddenRoofIds contains its id",
                isByteDrawn(ranges, ROOF_BYTE));
    }

    @Test
    public void wholeFloorAboveIsDrawnWhenHiddenRoofIdsIsEmpty()
    {
        // Same fixture, but hiddenRoofIds is EMPTY -- the state we suspect happens
        // when the native "remove all roofs" toggle and RuneLite's selective Roof
        // Removal plugin conflict.
        List<int[]> ranges = selectRanges(
                LEVEL_OFFSETS, RIDS, ROOF_START, ROOF_END,
                0, 0, 1, Collections.emptySet());

        // BUG REPRO: with hiddenRoofIds empty, the "draw the whole level" fallback
        // fires for floor 1, which includes the roof geometry that should have
        // been hidden.
        assertTrue("BUG: roof gets drawn anyway when hiddenRoofIds is empty",
                isByteDrawn(ranges, ROOF_BYTE));
    }
}