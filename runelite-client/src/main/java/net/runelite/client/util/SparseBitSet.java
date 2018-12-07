package net.runelite.client.util;

/*- This software is the work of Paladin Software International, Incorporated,
        *  based upon previous work done for and by Sun Microsystems, Inc. */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *  This class implements a set of bits that grows as needed. Each bit of the
 *  bit set represents a <code>boolean</code> value. The values of a
 *  <code>SparseBitSet</code> are indexed by non-negative integers.
 *  Individual indexed values may be examined, set, cleared, or modified by
 *  logical operations. One <code>SparseBitSet</code> or logical value may be
 *  used to modify the contents of (another) <code>SparseBitSet</code> through
 *  logical <b>AND</b>, logical <b>inclusive OR</b>, logical <b>exclusive
 *  OR</b>, and <b>And NOT</b> operations over all or part of the bit sets.
 *  <p>
 *  All values in a bit set initially have the value <code>false</code>.
 *  <p>
 *  Every bit set has a current size, which is the number of bits of space
 *  <i>nominally</i> in use by the bit set from the first set bit to just after
 *  the last set bit. The length of the bit set effectively tells the position
 *  available after the last bit of the SparseBitSet.
 *  <p>
 *  The maximum cardinality of a <code>SparseBitSet</code> is
 *  <code>Integer.MAX_VALUE</code>, which means the bits of a
 *  <code>SparseBitSet</code> are labelled <code>
 *  0</code>&nbsp;..&nbsp;<code>Integer.MAX_VALUE&nbsp;&minus;&nbsp;1</code>.
 *  After the last set bit of a <code>SparseBitSet</code>, any attempt to find
 *  a subsequent bit (<i>nextSetBit</i>()), will return an value of &minus;1.
 *  If an attempt is made to use <i>nextClearBit</i>(), and all the bits are
 *  set from the starting position of the search to the bit labelled
 *  <code>Integer.MAX_VALUE&nbsp;&minus;&nbsp;1</code>, then similarly &minus;1
 *  will be returned.
 *  <p>
 *  Unless otherwise noted, passing a null parameter to any of the methods in
 *  a <code>SparseBitSet</code> will result in a
 *  <code>NullPointerException</code>.
 *  <p>
 *  A <code>SparseBitSet</code> is not safe for multi-threaded use without
 *  external synchronization.
 *
 * @author      Bruce K. Haddon
 * @author      Arthur van Hoff
 * @author      Michael McCloskey
 * @author      Martin Buchholz
 * @version     1.0, 2009-03-17
 * @since       1.6
 */
public class SparseBitSet implements Cloneable, Serializable
{
    /*  My apologies for listing all the additional authors, but concepts, code,
        and even comments have been re-used in this class definition from code in
        the JDK that was written and/or maintained by these people. I owe a debt,
        which I acknowledge. But they are in no way responsible for what ever
        misuse I have made of their work.
                                                        Bruce K. Haddon
        The representation of a SparseBitSet is packed into "words", and the words
        are stored in arrays which are here referred to as "blocks." Blocks are
        accessed by two levels of indirection from the master "level 1" (whole)
        set array through second level arrays called "areas" (making the blocks
        "level3"). A "word" is a long, consisting of 64 bits, requiring six address
        bits to select a bit within a word (and this is considered in places to be
        a "level4"). This choice of a long for "word" is determined purely by
        performance concerns, and is built into the implementation in a deep way,
        because the references to blocks are always of the form "long[]." (This
        does not mean that blocks could not be changed to arrays of ints, but it
        would take some extensive work.)
        The fact that there are three levels is also deeply involved in the
        scanning algorithms, meaning that the accesses are always nested three
        deep. Again, the change this might be a large amount of work. On the
        other hand, these three levels have proven, so far, to provide adequate
        speed, and an storage efficient way to deal with sparseness.
        For simplicity, the level3 blocks and the level2 areas are always "full"
        size, i.e., LENGTH3 and LENGTH2 respectively, and for consistency, the
        fourth level is of length LENGTH4. The level1 structure is of variable
        length (as this may save scanning several thousand null pointers, and
        careful consideration must be taken of this at all times, in particular,
        when choosing to increase the size (see resize()). The only place where
        this array is reduced in size is when a clone is made, in which case it is
        created with the smallest size, and allowed to grow as entries are copied
        to it. That all the arrays are kept to power-of-2 sizes is a programming
        convenience (permitting shifts and  masks).
        Whenever possible, a level 3 block that contains no bits (all the words are
        zero, is discarded, and its reference is replaced by a null value.
        Similarly, level 2 areas that contain only null pointers (to level 3
        blocks) are discarded, and their references replaced by null values. This
        is the "normalized" condition, but does not have to be nor is strictly
        enforced. The operations still work if the representation is partially or
        totally "denormalized." In particular, the methods that deal with single
        bits (setting, flipping, clearing, etc.) do not attempt to normalize the
        set, in the interests of speed. However, when a set is scanned as the
        resultant set of some operation, then, in most cases, the set will be
        normalized--the exception being level2 areas that are not completly scanned
        in a particular pass.
        The sizes of the blocks and areas has been the result of some investigation
        with varying sizes, and the sizes selected appear to represent a reasonable
        "sweet" spot. There is, of course, no guarantee that these are the best
        for all possible situations, but, given that not having these the same
        for all bit sets would be hopelessly complex (bad enough as is), these
        values appear to be a fair compromise. */

    /**
     *  This value controls for format of the toString() output.
     * @see #toStringCompaction(int)
     */
    protected transient int compactionCount;

    /**
     *  The compaction count default.
     */
    static int compactionCountDefault = 2; // Note: this is not final!

    /**
     *  The storage for this SparseBitSet. The <i>i</i>th bit is stored in a word
     *  represented by a long value, and is at bit position <code>i % 64</code>
     *  within that word (where bit position 0 refers to the least significant bit
     *  and 63 refers to the most significant bit).
     *  <p>
     *  The words are organized into blocks, and the blocks are accessed by two
     *  additional levels of array indexing.
     */
    protected transient long[][][] bits;

    /**
     *  For the current size of the bits array, this is the maximum possible
     *  length of the bit set, i.e., the index of the last possible bit, plus one.
     *  Note: this not the value returned by <i>length</i>().
     * @see #resize(int)
     * @see #length()
     */
    protected transient int bitsLength;

    //==============================================================================
    //  The critical parameters. These are set up so that the compiler may
    //  pre-compute all the values as compile-time constants.
    //==============================================================================

    /**
     *  The number of bits in a long value.
     */
    protected static final int LENGTH4 = Long.SIZE;

    /**
     *  The number of bits in a positive integer, and the size of permitted index
     *  of a bit in the bit set.
     */
    protected static final int INDEX_SIZE = Integer.SIZE - 1;

    /**
     *  The label (index) of a bit in the bit set is essentially broken into
     *  4 "levels". Respectively (from the least significant end), level4, the
     *  address within word, the address within a level3 block, the address within
     *  a level2 area, and the level1 address of that area within the set.
     *
     *  LEVEL4 is the number of bits of the level4 address (number of bits need
     *  to address the bits in a long)
     */
    protected static final int LEVEL4 = 6;

    /**
     *  LEVEL3 is the number of bits of the level3 address.
     */
    protected static final int LEVEL3 = 5; // Do not change!
    /**
     *  LEVEL2 is the number of bits of the level2 address.
     */
    protected static final int LEVEL2 = 5; // Do not change!
    /**
     *  LEVEL1 is the number of bits of the level1 address.
     */
    protected static final int LEVEL1 = INDEX_SIZE - LEVEL2 - LEVEL3 - LEVEL4;

    /**
     *  MAX_LENGTH1 is the maximum number of entries in the level1 set array.
     */
    protected static final int MAX_LENGTH1 = 1 << LEVEL1;

    /**
     *  LENGTH2 is the number of entries in the any level2 area.
     */
    protected static final int LENGTH2 = 1 << LEVEL2;

    /**
     *  LENGTH3 is the number of entries in the any level3 block.
     */
    protected static final int LENGTH3 = 1 << LEVEL3;

    /**
     *  The shift to create the word index. (I.e., move it to the right end)
     */
    protected static final int SHIFT3 = LEVEL4;

    /**
     *  MASK3 is the mask to extract the LEVEL3 address from a word index
     *  (after shifting by SHIFT3).
     */
    protected static final int MASK3 = LENGTH3 - 1;

    /**
     *  SHIFT2 is the shift to bring the level2 address (from the word index) to
     *  the right end (i.e., after shifting by SHIFT3).
     */
    protected static final int SHIFT2 = LEVEL3;

    /**
     *  UNIT is the greatest number of bits that can be held in one level1 entry.
     *  That is, bits per word by words per level3 block by blocks per level2 area.
     */
    protected static final int UNIT = LENGTH2 * LENGTH3 * LENGTH4;

    /**
     *  MASK2 is the mask to extract the LEVEL2 address from a word index
     *  (after shifting by SHIFT3 and SHIFT2).
     */
    protected static final int MASK2 = LENGTH2 - 1;

    /**
     *  SHIFT1 is the shift to bring the level1 address (from the word index) to
     *  the right end (i.e., after shifting by SHIFT3).
     */
    protected static final int SHIFT1 = LEVEL2 + LEVEL3;

    /**
     *  LENGTH2_SIZE is maximum index of a LEVEL2 page.
     */
    protected static final int LENGTH2_SIZE = LENGTH2 - 1;

    /**
     *  LENGTH3_SIZE is maximum index of a LEVEL3 page.
     */
    protected static final int LENGTH3_SIZE = LENGTH3 - 1;

    /**
     *  LENGTH4_SIZE is maximum index of a bit in a LEVEL4 word.
     */
    protected static final int LENGTH4_SIZE = LENGTH4 - 1;

    /**
     *  Holds reference to the cache of statistics values computed by the
     *  UpdateStrategy
     * @see SparseBitSet.Cache
     * @see SparseBitSet.UpdateStrategy
     */
    protected transient Cache cache;

    //=============================================================================
    //  Stack structures used for recycling blocks
    //=============================================================================

    /**
     *  A spare level 3 block is kept for use when scanning. When a target block
     *  is needed, and there is not already one in the bit set, the spare is
     *  provided. If non-zero values are placed into this block, it is moved to the
     *  resulting set, and a new spare is acquired. Note: a new spare needs to
     *  be allocated when the set is cloned (so that the spare is not shared
     *  between two sets).
     */
    protected transient long[] spare;

    /** An empty level 3 block is kept for use when scanning. When a source block
     *  is needed, and there is not already one in the corresponding bit set, the
     *  ZERO_BLOCK is used (as a read-only block). It is a source of zero values
     *  so that code does not have to test for a null level3 block. This is a
     *  static block shared everywhere.
     */
    static final long[] ZERO_BLOCK = new long[LENGTH3];

    /*  Programming notes:
        i, j, and k are used to hold values that are actual bit indices (i.e.,
        the index (label) of the bit within the user's view of the bit set).
        u, v, and w, are used to hold values that refer to the indices of the
        words in the set array that are used to hold the bits (with 64 bits per
        word). These variable names, followed by 1, 2, or 3, refer to the component
        "level" parts of the complete word index.
        word (where used) is a potential entry to or from a block, containing 64
        bits of the bit set. The prefixes a, b, result, etc., refer to the bit
        sets from which these are coming or going. Without a prefix, or with the
        prefix "a," the set in question is "this" set (see next paragraph).
        Operations are conceived to be in the form a.op(b), thus in the discussion
        (not in the public Javadoc documentation) the two sets are referred to a
        "a" and "b", where the set referred to by "this" is usually set a.
        Hence, reference to set a is usually implicit, but set b will usually be
        explicit. Variables beginning with these letters hold values relevant to
        the corresponding set, and, in particular, these letters followed by
        1, 2, and 3 are used to refer to the corresponding (current) level1,
        level3 area, and level3 block, arrays.
        The resizing of the table takes place as necessary. In this regard, it is
        worth noting that the table is grown, but never shrunk (except in a new
        object formed by cloning).
        Similarly, care it taken to ensure that any supplied reference to a bit
        set (other than this) has an opportunity to fail for being null before
        any other set (including this) has its state changed. For the most
        part, this is allowed to happen "naturally," but the Strategies incorporate
        an explicit check when necessary.
        There is a amount of (almost) repetitive scanning code in many of the
        "singe bit" methods. The intent is that these methods for SparseBitSet be
        as small and as fast as possible.
        For the scanning of complete sets, or for ranges within complete sets,
        all of the scanning logic is built into one (somewhat enormous) method,
        setScanner(). This contains all the considerations for matching up
        corresponding level 3 blocks (if they exist), and then uses a Strategy
        object to do the processing on those level3 blocks. This keeps all
        the scanning and optimization logic in one place, and the Strategies are
        reasonably simple (see the definition of AbstractStrategy for a discussion
        of the tasks that must be defined therein).
        The test for index i (the first index in all cases) being in range is
        rather perverse, but the idea was to keep the actual number of comparisons
        to a minimum, hence the check is for "(i + 1) < 1". This is almost but not
        quite equivalent to "i < 0", although it is for all values of i except
        i=Integer.MAX_VALUE. In this latter case, (i + 1) "overflows" to
        -(Integer.MAX_VALUE + 1), and thus appears to be less than 1, and thus the
        check picks up the other disallowed case. Let us hope the compiler never
        gets smart enough to try to do the apparent optimisation! */

    /**
     *  Constructor for a new (sparse) bit set. All bits initially are effectively
     *  <code>false</code>. This is a internal constructor that collects all the
     *  needed actions to initialise the bit set.
     *  <p>
     *  The capacity is taken to be a <i>suggestion</i> for a size of the bit set,
     *  in bits. An appropiate table size (a power of two) is then determined and
     *  used. The size will be grown as needed to accomodate any bits addressed
     *  during the use of the bit set.
     *
     * @param       capacity a size in terms of bits
     * @param       compactionCount the compactionCount to be inherited (for
     *              internal generation)
     * @exception   NegativeArraySizeException if the specified initial size
     *              is negative
     * @since       1.6
     */
    protected SparseBitSet(int capacity, int compactionCount)
            throws NegativeArraySizeException
    {
        /*  Array size is computed based on this being a capacity given in bits. */
        if (capacity < 0) // capacity can't be negative -- could only come from
            throw new NegativeArraySizeException( //  an erroneous user given
                    "(requested capacity=" + capacity + ") < 0"); // nbits value
        resize(capacity - 1); //  Resize takes last usable index
        this.compactionCount = compactionCount;
        /*  Ensure there is a spare level 3 block for the use of the set scanner.*/
        constructorHelper();
        statisticsUpdate();
    }

    /**
     *  Constructs an empty bit set with the default initial size.
     *  Initially all bits are effectively <code>false</code>.
     *
     * @since       1.6
     */
    public SparseBitSet()
    {
        /*   By requesting 1 bit, will actually get UNIT number of bits. */
        this(1, compactionCountDefault);
    }

    /**
     *  Creates a bit set whose initial size is large enough to efficiently
     *  represent bits with indices in the range <code>0</code> through
     *  at least <code>nbits-1</code>. Initially all bits are effectively
     *  <code>false</code>.
     *  <p>
     *  No guarantees are given for how large or small the actual object will be.
     *  The setting of bits above the given range is permitted (and will perhaps
     *  eventually cause resizing).
     *
     * @param       nbits the initial provisional length of the SparseBitSet
     * @throws      java.lang.NegativeArraySizeException if the specified initial
     *              length is negative
     * @see         #SparseBitSet()
     * @since       1.6
     */
    public SparseBitSet(int nbits) throws NegativeArraySizeException
    {
        this(nbits, compactionCountDefault);
    }

    /**
     *  Performs a logical <b>AND</b> of the addressed target bit with the argument
     *  value. This bit set is modified so that the addressed bit has the value
     *  <code>true</code> if and only if it both initially had the value
     *  <code>true</code> and the argument value is also <code>true</code>.
     *
     * @param       i a bit index
     * @param       value a boolean value to <b>AND</b> with that bit
     * @exception   IndexOutOfBoundsException if the specified index is negative
     *              or equal to Integer.MAX_VALUE
     * @since       1.6
     */
    public void and(int i, boolean value) throws IndexOutOfBoundsException
    {
        if ((i + 1) < 1)
            throw new IndexOutOfBoundsException("i=" + i);
        if (!value)
            clear(i);
    }

    /**
     *  Performs a logical <b>AND</b> of this target bit set with the argument bit
     *  set within the given range of bits. Within the range, this bit set is
     *  modified so that each bit in it has the value <code>true</code> if and only
     *  if it both initially had the value <code>true</code> and the corresponding
     *  bit in the bit set argument also had the value <code>true</code>. Outside
     *  the range, this set is not changed.
     *
     * @param       i index of the first bit to be included in the operation
     * @param       j index after the last bit to included in the operation
     * @param       b a SparseBitSet
     * @exception   IndexOutOfBoundsException if <code>i</code> is negative or
     *              equal to Integer.MAX_VALUE, or <code>j</code> is negative,
     *              or <code>i</code> is larger than <code>j</code>
     * @since       1.6
     */
    public void and(int i, int j, SparseBitSet b) throws IndexOutOfBoundsException
    {
        setScanner(i, j, b, andStrategy);
    }

    /**
     *  Performs a logical <b>AND</b> of this target bit set with the argument bit
     *  set. This bit set is modified so that each bit in it has the value
     *  <code>true</code> if and only if it both initially had the value
     *  <code>true</code> and the corresponding bit in the bit set argument also
     *  had the value <code>true</code>.
     *
     * @param       b a SparseBitSet
     * @since       1.6
     */
    public void and(SparseBitSet b)
    {
        nullify(Math.min(bits.length, b.bits.length)); // Optimisation
        setScanner(0, Math.min(bitsLength, b.bitsLength), b, andStrategy);
    }

    /**
     *  Performs a logical <b>AND</b> of the two given <code>SparseBitSet</code>s.
     *  The returned <code>SparseBitSet</code> is created so that each bit in it
     *  has the value <code>true</code> if and only if both the given sets
     *  initially had the corresponding bits <code>true</code>, otherwise
     *  <code>false</code>.
     *
     * @param       a a SparseBitSet
     * @param       b another SparseBitSet
     * @return      a new SparseBitSet representing the <b>AND</b> of the two sets
     * @since       1.6
     */
    public static SparseBitSet and(SparseBitSet a, SparseBitSet b)
    {
        final SparseBitSet result = a.clone();
        result.and(b);
        return result;
    }

    /**
     *  Performs a logical <b>AndNOT</b> of the addressed target bit with the
     *  argument value. This bit set is modified so that the addressed bit has the
     *  value <code>true</code> if and only if it both initially had the value
     *  <code>true</code> and the argument value is <code>false</code>.
     *
     * @param       i a bit index
     * @param       value a boolean value to AndNOT with that bit
     * @exception   IndexOutOfBoundsException if the specified index is negative
     *              or equal to Integer.MAX_VALUE
     * @since       1.6
     */
    public void andNot(int i, boolean value)
    {
        if ((i + 1) < 1)
            throw new IndexOutOfBoundsException("i=" + i);
        if (value)
            clear(i);
    }

    /**
     *  Performs a logical <b>AndNOT</b> of this target bit set with the argument
     *  bit set within the given range of bits. Within the range, this bit set is
     *  modified so that each bit in it has the value <code>true</code> if and only
     *  if it both initially had the value <code>true</code> and the corresponding
     *  bit in the bit set argument has the value <code>false</code>. Outside
     *  the range, this set is not changed.
     *
     * @param       i index of the first bit to be included in the operation
     * @param       j index after the last bit to included in the operation
     * @param       b the SparseBitSet with which to mask this SparseBitSet
     * @exception   IndexOutOfBoundsException if <code>i</code> is negative or
     *              equal to Integer.MAX_VALUE, or <code>j</code> is negative,
     *              or <code>i</code> is larger than <code>j</code>
     * @since       1.6
     */
    public void andNot(int i, int j, SparseBitSet b)
            throws IndexOutOfBoundsException
    {
        setScanner(i, j, b, andNotStrategy);
    }

    /**
     *  Performs a logical <b>AndNOT</b> of this target bit set with the argument
     *  bit set. This bit set is modified so that each bit in it has the value
     *  <code>true</code> if and only if it both initially had the value
     *  <code>true</code> and the corresponding bit in the bit set argument has
     *  the value <code>false</code>.
     *
     * @param       b the SparseBitSet with which to mask this SparseBitSet
     * @since       1.6
     */
    public void andNot(SparseBitSet b)
    {
        setScanner(0, Math.min(bitsLength, b.bitsLength), b, andNotStrategy);
    }

    /**
     *  Creates a bit set from thie first <code>SparseBitSet</code> whose
     *  corresponding bits are cleared by the set bits of the second
     *  <code>SparseBitSet</code>. The resulting bit set is created so that a bit
     *  in it has the value <code>true</code> if and only if the corresponding bit
     *  in the <code>SparseBitSet</code> of the first is set, and that same
     *  corresponding bit is not set in the <code>SparseBitSet</code> of the second
     *  argument.
     *
     * @param a     a SparseBitSet
     * @param b     another SparseBitSet
     * @return      a new SparseBitSet representing the <b>AndNOT</b> of the
     *              two sets
     * @since       1.6
     */
    public static SparseBitSet andNot(SparseBitSet a, SparseBitSet b)
    {
        final SparseBitSet result = a.clone();
        result.andNot(b);
        return result;
    }

    /**
     *  Returns the number of bits set to <code>true</code> in this
     *  <code>SparseBitSet</code>.
     *
     * @return      the number of bits set to true in this SparseBitSet
     * @since       1.6
     */
    public int cardinality()
    {
        statisticsUpdate(); // Update size, cardinality and length values
        return cache.cardinality;
    }

    /**
     *  Sets the bit at the specified index to <code>false</code>.
     *
     * @param       i a bit index.
     * @exception   IndexOutOfBoundsException if the specified index is negative
     *              or equal to Integer.MAX_VALUE.
     * @since       1.6
     */
    public void clear(int i)
    {
        /*  In the interests of speed, no check is made here on whether the
            level3 block goes to all zero. This may be found and corrected
            in some later operation. */
        if ((i + 1) < 1)
            throw new IndexOutOfBoundsException("i=" + i);
        if (i >= bitsLength)
            return;
        final int w = i >> SHIFT3;
        long[][] a2;
        if ((a2 = bits[w >> SHIFT1]) == null)
            return;
        long[] a3;
        if ((a3 = a2[(w >> SHIFT2) & MASK2]) == null)
            return;
        a3[w & MASK3] &= ~(1L << i); //  Clear the indicated bit
        cache.hash = 0; //  Invalidate size, etc.,
    }

    /**
     *  Sets the bits from the specified <code>i</code> (inclusive) to the
     *  specified <code>j</code> (exclusive) to <code>false</code>.
     *
     * @param       i index of the first bit to be cleared
     * @param       j index after the last bit to be cleared
     * @exception   IndexOutOfBoundsException if <code>i</code> is negative or
     *              equal to Integer.MAX_VALUE, or <code>j</code> is negative,
     *              or <code>i</code> is larger than <code>j</code>
     * @since       1.6
     */
    public void clear(int i, int j) throws IndexOutOfBoundsException
    {
        setScanner(i, j, null, clearStrategy);
    }

    /**
     *  Sets all of the bits in this <code>SparseBitSet</code> to
     *  <code>false</code>.
     *
     * @since       1.6
     */
    public void clear()
    {
        /*  This simply resets to null all the entries in the set. */
        nullify(0);
    }

    /**
     *  Cloning this <code>SparseBitSet</code> produces a new
     *  <code>SparseBitSet</code> that is <i>equal</i>() to it. The clone of the
     *  bit set is another bit set that has exactly the same bits set to
     *  <code>true</code> as this bit set.
     *  <p>
     *  Note: the actual space allocated to the clone tries to minimise the actual
     *  amount of storage allocated to hold the bits, while still trying to
     *  keep access to the bits being a rapid as possible. Since the space
     *  allocated to a <code>SparseBitSet</code> is not normally decreased,
     *  replacing a bit set by its clone may be a way of both managing memory
     *  consumption and improving the rapidity of access.
     *
     * @return      a clone of this SparseBitSet
     * @since       1.6
     */
    @Override
    public SparseBitSet clone()
    {
        try
        {
            final SparseBitSet result = (SparseBitSet) super.clone();
            /*  Clear out the shallow copy of the set array (which contains just
                copies of the references from this set), and then replace these
                by a deep copy (created by a "copy" from the set being cloned . */
            result.bits = null;
            result.resize(1);
            /*  Ensure the clone is not sharing a copy of a spare block with
                the cloned set, nor the cache set, nor any of the visitors (which
                are linked to their parent object) (Not all visitors actually use
                this link to their containing object, but they are reset here just
                in case of  future changes). */
            result.constructorHelper();
            result.equalsStrategy = null;
            result.setScanner(0, bitsLength, this, copyStrategy);
            return result;
        }
        catch (CloneNotSupportedException ex)
        {
            /*  This code has not been unit tested. Inspection offers hope
                that is will work, but it likely never to be used. */
            throw new InternalError(ex.getMessage());
        }
    }

    /**
     *  Compares this object against the specified object. The result is
     *  <code>true</code> if and only if the argument is not <code>null</code>
     *  and is a <code>SparseBitSet</code> object that has exactly the same bits
     *  set to <code>true</code> as this bit set. That is, for every nonnegative
     *  <code>i</code> indexing a bit in the set,
     *  <pre>((SparseBitSet)obj).get(i) == this.get(i)</pre>
     *  must be true.
     *
     * @param       obj the Object with which to compare
     * @return      <code>true</code> if the objects are equivalent;
     *              <code>false</code> otherwise.
     * @since       1.6
     */
    @Override
    public boolean equals(Object obj)
    {
        /*  Sanity and quick checks. */
        if (!(obj instanceof SparseBitSet))
            return false;
        final SparseBitSet b = (SparseBitSet) obj;
        if (this == b)
            return true; // Identity

        /*  Do the real work.  */
        if (equalsStrategy == null)
            equalsStrategy = new EqualsStrategy();

        setScanner(0, Math.max(bitsLength, b.bitsLength), b, equalsStrategy);
        return equalsStrategy.result;
    }

    /**
     *  Sets the bit at the specified index to the complement of its current value.
     *
     * @param       i the index of the bit to flip
     * @exception   IndexOutOfBoundsException if the specified index is negative
     *              or equal to Integer.MAX_VALUE
     * @since       1.6
     */
    public void flip(int i)
    {
        if ((i + 1) < 1)
            throw new IndexOutOfBoundsException("i=" + i);
        final int w = i >> SHIFT3;
        final int w1 = w >> SHIFT1;
        final int w2 = (w >> SHIFT2) & MASK2;

        if (i >= bitsLength)
            resize(i);
        long[][] a2;
        if ((a2 = bits[w1]) == null)
            a2 = bits[w1] = new long[LENGTH2][];
        long[] a3;
        if ((a3 = a2[w2]) == null)
            a3 = a2[w2] = new long[LENGTH3];
        a3[w & MASK3] ^= 1L << i; //Flip the designated bit
        cache.hash = 0; //  Invalidate size, etc., values
    }

    /**
     *  Sets each bit from the specified <code>i</code> (inclusive) to the
     *  specified <code>j</code> (exclusive) to the complement of its current
     *  value.
     *
     * @param       i index of the first bit to flip
     * @param       j index after the last bit to flip
     * @exception   IndexOutOfBoundsException if <code>i</code> is negative or is
     *              equal to Integer.MAX_VALUE, or <code>j</code> is negative, or
     *              <code>i</code> is larger than <code>j</code>
     * @since       1.6
     */
    public void flip(int i, int j) throws IndexOutOfBoundsException
    {
        setScanner(i, j, null, flipStrategy);
    }

    /**
     *  Returns the value of the bit with the specified index. The value is
     *  <code>true</code> if the bit with the index <code>i</code> is currently set
     *  in this <code>SparseBitSet</code>; otherwise, the result is
     *  <code>false</code>.
     *
     * @param       i the bit index
     * @return      the boolean value of the bit with the specified index.
     * @exception   IndexOutOfBoundsException if the specified index is negative
     *              or equal to Integer.MAX_VALUE
     * @since       1.6
     */
    public boolean get(int i)
    {
        if ((i + 1) < 1)
            throw new IndexOutOfBoundsException("i=" + i);
        final int w = i >> SHIFT3;

        long[][] a2;
        long[] a3;
        return i < bitsLength && (a2 = bits[w >> SHIFT1]) != null
                && (a3 = a2[(w >> SHIFT2) & MASK2]) != null
                && ((a3[w & MASK3] & (1L << i)) != 0);
    }

    /**
     *  Returns a new <code>SparseBitSet</code> composed of bits from this
     *  <code>SparseBitSet</code> from <code>i</code> (inclusive) to <code>j</code>
     *  (exclusive).
     *
     * @param       i index of the first bit to include
     * @param       j index after the last bit to include
     * @return      a new SparseBitSet from a range of this SparseBitSet
     * @exception   IndexOutOfBoundsException if <code>i</code> is negative or is
     *              equal to Integer.MAX_VALUE, or <code>j</code> is negative, or
     *              <code>i</code> is larger than <code>j</code>
     * @since       1.6
     */
    public SparseBitSet get(int i, int j) throws IndexOutOfBoundsException
    {
        final SparseBitSet result = new SparseBitSet(j, compactionCount);
        result.setScanner(i, j, this, copyStrategy);
        return result;
    }

    /**
     *  Returns a hash code value for this bit set. The hash code depends only on
     *  which bits have been set within this <code>SparseBitSet</code>. The
     *  algorithm used to compute it may be described as follows.
     *  <p>
     *  Suppose the bits in the <code>SparseBitSet</code> were to be stored in an
     *  array of <code>long</code> integers called, say, <code>bits</code>, in such
     *  a manner that bit <code>i</code> is set in the <code>SparseBitSet</code>
     *  (for nonnegative values of  <code>i</code>) if and only if the expression
     *  <pre>
     *  ((i&gt;&gt;6) &lt; bits.length) &amp;&amp; ((bits[i&gt;&gt;6] &amp; (1L &lt;&lt; (bit &amp; 0x3F))) != 0)
     *  </pre>
     *  is true. Then the following definition of the <code>hashCode</code> method
     *  would be a correct implementation of the actual algorithm:
     *  <pre>
     *  public int hashCode()
     *  {
     *      long hash = 1234L;
     *      for( int i = bits.length; --i &gt;= 0; )
     *          hash ^= bits[i] * (i + 1);
     *      return (int)((h &gt;&gt; 32) ^ h);
     *  }</pre>
     *  Note that the hash code values change if the set of bits is altered.
     *
     * @return      a hash code value for this bit set
     * @since       1.6
     * @see         Object#equals(Object)
     * @see         java.util.Hashtable
     */
    @Override
    public int hashCode()
    {
        statisticsUpdate();
        return cache.hash;
    }

    /**
     *  Returns true if the specified <code>SparseBitSet</code> has any bits
     *  within the given range <code>i</code> (inclusive) to <code>j</code>
     *  (exclusive) set to <code>true</code> that are also set to <code>true</code>
     *  in the same range of this <code>SparseBitSet</code>.
     *
     * @param       i index of the first bit to include
     * @param       j index after the last bit to include
     * @param       b the SparseBitSet with which to intersect
     * @return      the boolean indicating whether this SparseBitSet intersects the
     *              specified SparseBitSet
     * @exception   IndexOutOfBoundsException if <code>i</code> is negative or
     *              equal to Integer.MAX_VALUE, or <code>j</code> is negative,
     *              or <code>i</code> is larger than <code>j</code>
     * @since       1.6
     */
    public boolean intersects(int i, int j, SparseBitSet b)
            throws IndexOutOfBoundsException
    {
        setScanner(i, j, b, intersectsStrategy);
        return intersectsStrategy.result;
    }

    /**
     *  Returns true if the specified <code>SparseBitSet</code> has any bits set to
     *  <code>true</code> that are also set to <code>true</code> in this
     *  <code>SparseBitSet</code>.
     *
     * @param       b a SparseBitSet with which to intersect
     * @return      boolean indicating whether this SparseBitSet intersects the
     *              specified SparseBitSet
     * @since       1.6
     */
    public boolean intersects(SparseBitSet b)
    {
        setScanner(0, Math.max(bitsLength, b.bitsLength), b, intersectsStrategy);
        return intersectsStrategy.result;
    }

    /**
     *  Returns true if this <code>SparseBitSet</code> contains no bits that are
     *  set to <code>true</code>.
     *
     * @return      the boolean indicating whether this SparseBitSet is empty
     * @since       1.6
     */
    public boolean isEmpty()
    {
        statisticsUpdate();
        return cache.cardinality == 0;
    }

    /**
     *  Returns the "logical length" of this <code>SparseBitSet</code>: the index
     *  of the highest set bit in the <code>SparseBitSet</code> plus one. Returns
     *  zero if the <code>SparseBitSet</code> contains no set bits.
     *
     * @return      the logical length of this SparseBitSet
     * @since       1.6
     */
    public int length()
    {
        statisticsUpdate();
        return cache.length;
    }

    /**
     *  Returns the index of the first bit that is set to <code>false</code> that
     *  occurs on or after the specified starting index.
     *
     * @param       i the index to start checking from (inclusive)
     * @return      the index of the next clear bit, or -1 if there is no such bit
     * @exception   IndexOutOfBoundsException if the specified index is negative
     * @since       1.6
     */
    public int nextClearBit(int i)
    {
        /*  The index of this method is permitted to be Integer.MAX_VALUE, as this
            is needed to make this method work together with the method
            nextSetBit()--as might happen if a search for the next clear bit is
            started after finding a set bit labelled Integer.MAX_VALUE-1. This
            case is not optimised, the code will eventually return -1 (since
            the Integer.MAX_VALUEth bit does "exist," and is 0. */

        if (i < 0)
            throw new IndexOutOfBoundsException("i=" + i);
        /*  This is the word from which the search begins. */
        int w = i >> SHIFT3;
        int w3 = w & MASK3;
        int w2 = (w >> SHIFT2) & MASK2;
        int w1 = w >> SHIFT1;

        long nword = ~0L << i;
        final int aLength = bits.length;

        long[][] a2;
        long[] a3;
        /*  Is the next clear bit in the same word at the nominated beginning bit
        (including the nominated beginning bit itself). The first check is
        whether the starting bit is within the structure at all. */
        if (w1 < aLength && (a2 = bits[w1]) != null
                && (a3 = a2[w2]) != null
                && ((nword = ~a3[w3] & (~0L << i))) == 0L)
        {
            /*  So now start a search though the rest of the entries for
                a null area or block, or a clear bit (a set bit in the
                complemented value). */
            ++w;
            w3 = w & MASK3;
            w2 = (w >> SHIFT2) & MASK2;
            w1 = w >> SHIFT1;
            nword = ~0L;
            loop: for (; w1 != aLength; ++w1)
            {
                if ((a2 = bits[w1]) == null)
                    break;
                for (; w2 != LENGTH2; ++w2)
                {
                    if ((a3 = a2[w2]) == null)
                        break loop;
                    for (; w3 != LENGTH3; ++w3)
                        if ((nword = ~a3[w3]) != 0)
                            break loop;
                    w3 = 0;
                }
                w2 = w3 = 0;
            }
        }
        final int result = (((w1 << SHIFT1) + (w2 << SHIFT2) + w3) << SHIFT3)
                + Long.numberOfTrailingZeros(nword);
        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    /**
     *  Returns the index of the first bit that is set to <code>true</code> that
     *  occurs on or after the specified starting index. If no such it exists then
     *  -1 is returned.
     *  <p>
     *  To iterate over the <code>true</code> bits in a <code>SparseBitSet
     *  sbs</code>, use the following loop:
     *
     *  <pre>
     *  for( int i = sbbits.nextSetBit(0); i &gt;= 0; i = sbbits.nextSetBit(i+1) )
     *  {
     *      // operate on index i here
     *  }</pre>
     *
     * @param       i the index to start checking from (inclusive)
     * @return      the index of the next set bit
     * @exception   IndexOutOfBoundsException if the specified index is negative
     * @since       1.6
     */
    public int nextSetBit(int i)
    {
        /*  The index value (i) of this method is permitted to be Integer.MAX_VALUE,
            as this is needed to make the loop defined above work: just in case the
            bit labelled Integer.MAX_VALUE-1 is set. This case is not optimised:
            but eventually -1 will be returned, as this will be included with
            any search that goes off the end of the level1 array. */

        if (i < 0)
            throw new IndexOutOfBoundsException("i=" + i);
        /*  This is the word from which the search begins. */
        int w = i >> SHIFT3;
        int w3 = w & MASK3;
        int w2 = (w >> SHIFT2) & MASK2;
        int w1 = w >> SHIFT1;

        long word = 0L;
        final int aLength = bits.length;

        long[][] a2;
        long[] a3;
        /*  Is the next set bit in the same word at the nominated beginning bit
        (including the nominated beginning bit itself). The first check is
        whether the starting bit is within the structure at all. */
        if (w1 < aLength && ((a2 = bits[w1]) == null
                || (a3 = a2[w2]) == null
                || ((word = a3[w3] & (~0L << i)) == 0L)))
        {
            /*  So now start a search though the rest of the entries for a bit. */
            ++w;
            w3 = w & MASK3;
            w2 = (w >> SHIFT2) & MASK2;
            w1 = w >> SHIFT1;
            major: for (; w1 != aLength; ++w1)
            {
                if ((a2 = bits[w1]) != null)
                    for (; w2 != LENGTH2; ++w2)
                    {
                        if ((a3 = a2[w2]) != null)
                            for (; w3 != LENGTH3; ++w3)
                                if ((word = a3[w3]) != 0)
                                    break major;
                        w3 = 0;
                    }
                w2 = w3 = 0;
            }
        }
        return (w1 >= aLength ? -1
                : (((w1 << SHIFT1) + (w2 << SHIFT2) + w3) << SHIFT3)
                + Long.numberOfTrailingZeros(word));
    }

    /**
     * Returns the index of the nearest bit that is set to {@code false}
     * that occurs on or before the specified starting index.
     * If no such bit exists, or if {@code -1} is given as the
     * starting index, then {@code -1} is returned.
     *
     * @param  i the index to start checking from (inclusive)
     * @return the index of the previous clear bit, or {@code -1} if there
     *         is no such bit
     * @throws IndexOutOfBoundsException if the specified index is less
     *         than {@code -1}
     * @since  1.2
     * @see java.util.BitSet#previousClearBit
     */
    public int previousClearBit(int i)
    {
        if (i < 0)
        {
            if (i == -1)
                return -1;
            throw new IndexOutOfBoundsException("i=" + i);
        }

        final long[][][] bits = this.bits;
        final int aSize = bits.length - 1;

        int w = i >> SHIFT3;
        int w3 = w & MASK3;
        int w2 = (w >> SHIFT2) & MASK2;
        int w1 = w >> SHIFT1;
        if (w1 > aSize)
            return i;
        w1 = Math.min(w1, aSize);
        int w4 = i % LENGTH4;

        long word;
        long[][] a2;
        long[] a3;

        for (; w1 >= 0; --w1)
        {
            if ((a2 = bits[w1]) == null)
                return (((w1 << SHIFT1) + (w2 << SHIFT2) + w3) << SHIFT3) + w4;
            for (; w2 >= 0; --w2)
            {
                if ((a3 = a2[w2]) == null)
                    return (((w1 << SHIFT1) + (w2 << SHIFT2) + w3) << SHIFT3) + w4;
                for (; w3 >= 0; --w3)
                {
                    if ((word = a3[w3]) == 0)
                        return (((w1 << SHIFT1) + (w2 << SHIFT2) + w3) << SHIFT3) + w4;
                    for (int bitIdx = w4; bitIdx >= 0; --bitIdx)
                    {
                        if ((word & (1L << bitIdx)) == 0)
                            return (((w1 << SHIFT1) + (w2 << SHIFT2) + w3) << SHIFT3) + bitIdx;
                    }
                    w4 = LENGTH4_SIZE;
                }
                w3 = LENGTH3_SIZE;
            }
            w2 = LENGTH2_SIZE;
        }
        return -1;
    }

    /**
     * Returns the index of the nearest bit that is set to {@code true}
     * that occurs on or before the specified starting index.
     * If no such bit exists, or if {@code -1} is given as the
     * starting index, then {@code -1} is returned.
     *
     * @param  i the index to start checking from (inclusive)
     * @return the index of the previous set bit, or {@code -1} if there
     *         is no such bit
     * @throws IndexOutOfBoundsException if the specified index is less
     *         than {@code -1}
     * @since  1.2
     * @see java.util.BitSet#previousSetBit
     */
    public int previousSetBit(int i)
    {
        if (i < 0)
        {
            if (i == -1)
                return -1;
            throw new IndexOutOfBoundsException("i=" + i);
        }

        final long[][][] bits = this.bits;
        final int aSize = bits.length - 1;

        /*  This is the word from which the search begins. */
        final int w = i >> SHIFT3;
        int w1 = w >> SHIFT1;
        int w2, w3, w4;
        /*  But if its off the end of the array, start from the very end. */
        if (w1 > aSize)
        {
            w1 = aSize;
            w2 = LENGTH2_SIZE;
            w3 = LENGTH3_SIZE;
            w4 = LENGTH4_SIZE;
        }
        else
        {
            w2 = (w >> SHIFT2) & MASK2;
            w3 = w & MASK3;
            w4 = i % LENGTH4;
        }
        long word;
        long[][] a2;
        long[] a3;
        for (; w1 >= 0; --w1)
        {
            if ((a2 = bits[w1]) != null)
                for (; w2 >= 0; --w2)
                {
                    if ((a3 = a2[w2]) != null)
                        for (; w3 >= 0; --w3)
                        {
                            if ((word = a3[w3]) != 0)
                                for (int bitIdx = w4; bitIdx >= 0; --bitIdx)
                                {
                                    if ((word & (1L << bitIdx)) != 0)
                                        return (((w1 << SHIFT1) + (w2 << SHIFT2) + w3) << SHIFT3) + bitIdx;
                                }
                            w4 = LENGTH4_SIZE;
                        }
                    w3 = LENGTH3_SIZE;
                    w4 = LENGTH4_SIZE;
                }
            w2 = LENGTH2_SIZE;
            w3 = LENGTH3_SIZE;
            w4 = LENGTH4_SIZE;
        }
        return -1;
    }

    /**
     *  Performs a logical <b>OR</b> of the addressed target bit with the
     *  argument value. This bit set is modified so that the addressed bit has the
     *  value <code>true</code> if and only if it both initially had the value
     *  <code>true</code> or the argument value is <code>true</code>.
     *
     * @param       i a bit index
     * @param       value a boolean value to OR with that bit
     * @exception   IndexOutOfBoundsException if the specified index is negative
     *              or equal to Integer.MAX_VALUE
     * @since       1.6
     */
    public void or(int i, boolean value)
    {
        if ((i + 1) < 1)
            throw new IndexOutOfBoundsException("i=" + i);
        if (value)
            set(i);
    }

    /**
     *  Performs a logical <b>OR</b> of the addressed target bit with the
     *  argument value within the given range. This bit set is modified so that
     *  within the range a bit in it has the value <code>true</code> if and only if
     *  it either already had the value <code>true</code> or the corresponding bit
     *  in the bit set argument has the value <code>true</code>. Outside the range
     *  this set is not changed.
     *
     * @param       i index of the first bit to be included in the operation
     * @param       j index after the last bit to included in the operation
     * @param       b the SparseBitSet with which to perform the <b>OR</b>
     *              operation with this SparseBitSet
     * @exception   IndexOutOfBoundsException if <code>i</code> is negative or
     *              equal to Integer.MAX_VALUE, or <code>j</code> is negative,
     *              or <code>i</code> is larger than <code>j</code>
     * @since       1.6
     */
    public void or(int i, int j, SparseBitSet b) throws IndexOutOfBoundsException
    {
        setScanner(i, j, b, orStrategy);
    }

    /**
     *  Performs a logical <b>OR</b> of this bit set with the bit set argument.
     *  This bit set is modified so that a bit in it has the value <code>true</code>
     *  if and only if it either already had the value <code>true</code> or the
     *  corresponding bit in the bit set argument has the value <code>true</code>.
     *
     * @param       b the SparseBitSet with which to perform the <b>OR</b>
     *              operation with this SparseBitSet
     * @since       1.6
     */
    public void or(SparseBitSet b)
    {
        setScanner(0, b.bitsLength, b, orStrategy);
    }

    /**
     *  Performs a logical <b>OR</b> of the two given <code>SparseBitSet</code>s.
     *  The returned <code>SparseBitSet</code> is created so that a bit in it has
     *  the value <code>true</code> if and only if it either had the value
     *  <code>true</code> in the set given by the first arguemetn or had the value
     *  <code>true</code> in the second argument, otherwise <code>false</code>.
     *
     * @param       a a SparseBitSet
     * @param       b another SparseBitSet
     * @return      new SparseBitSet representing the <b>OR</b> of the two sets
     * @since       1.6
     */
    public static SparseBitSet or(SparseBitSet a, SparseBitSet b)
    {
        final SparseBitSet result = a.clone();
        result.or(b);
        return result;
    }

    /**
     *  Sets the bit at the specified index.
     *
     * @param       i a bit index
     * @exception   IndexOutOfBoundsException if the specified index is negative
     *              or equal to Integer.MAX_VALUE
     * @since       1.6
     */
    public void set(int i)
    {
        if ((i + 1) < 1)
            throw new IndexOutOfBoundsException("i=" + i);
        final int w = i >> SHIFT3;
        final int w1 = w >> SHIFT1;
        final int w2 = (w >> SHIFT2) & MASK2;

        if (i >= bitsLength)
            resize(i);
        long[][] a2;
        if ((a2 = bits[w1]) == null)
            a2 = bits[w1] = new long[LENGTH2][];
        long[] a3;
        if ((a3 = a2[w2]) == null)
            a3 = a2[w2] = new long[LENGTH3];
        a3[w & MASK3] |= 1L << i;
        cache.hash = 0; //Invalidate size, etc., scan
    }

    /**
     *  Sets the bit at the specified index to the specified value.
     *
     * @param       i a bit index
     * @param       value a boolean value to set
     * @exception   IndexOutOfBoundsException if the specified index is negative
     *              or equal to Integer.MAX_VALUE
     * @since       1.6
     */
    public void set(int i, boolean value)
    {
        if (value)
            set(i);
        else
            clear(i);
    }

    /**
     *  Sets the bits from the specified <code>i</code> (inclusive) to the specified
     *  <code>j</code> (exclusive) to <code>true</code>.
     *
     * @param       i index of the first bit to be set
     * @param       j index after the last bit to be se
     * @exception   IndexOutOfBoundsException if <code>i</code> is negative or is
     *              equal to Integer.MAX_INT, or <code>j</code> is negative, or
     *              <code>i</code> is larger than <code>j</code>.
     * @since       1.6
     */
    public void set(int i, int j) throws IndexOutOfBoundsException
    {
        setScanner(i, j, null, setStrategy);
    }

    /**
     *  Sets the bits from the specified <code>i</code> (inclusive) to the specified
     *  <code>j</code> (exclusive) to the specified value.
     *
     * @param       i index of the first bit to be set
     * @param       j index after the last bit to be set
     * @param       value to which to set the selected bits
     * @exception   IndexOutOfBoundsException if <code>i</code> is negative or is
     *              equal to Integer.MAX_VALUE, or <code>j</code> is negative, or
     *              <code>i</code> is larger than <code>j</code>
     * @since       1.6
     */
    public void set(int i, int j, boolean value)
    {
        if (value)
            set(i, j);
        else
            clear(i, j);
    }

    /**
     *  Returns the number of bits of space nominally in use by this
     *  <code>SparseBitSet</code> to represent bit values. The count of bits in
     *  the set is the (label of the last set bit) + 1 - (the label of the first
     *  set bit).
     *
     * @return      the number of bits (true and false) nominally in this bit set
     *              at this moment
     * @since       1.6
     */
    public int size()
    {
        statisticsUpdate();
        return cache.size;
    }

    /**
     *  Convenience method for statistics if the individual results are not needed.
     *
     * @return      a String detailing the statistics of the bit set
     * @see         #statistics(String[])
     * @since       1.6
     */
    public String statistics()
    {
        return statistics(null);
    }

    /**
     *  Determine, and create a String with the bit set statistics. The statistics
     *  include: Size, Length, Cardinality, Total words (<i>i.e.</i>, the total
     *  number of 64-bit "words"), Set array length (<i>i.e.</i>, the number of
     *  references that can be held by the top level array, Level2 areas in use,
     *  Level3 blocks in use,, Level2 pool size, Level3 pool size, and the
     *  Compaction count.
     *  <p>
     *  This method is intended for diagnostic use (as it is relatively expensive
     *  in time), but can be useful in understanding an application's use of a
     *  <code>SparseBitSet</code>.
     *
     * @param       values an array for the individual results (if not null)
     * @return      a String detailing the statistics of the bit set
     * @since       1.6
     */
    public String statistics(String[] values)
    {
        statisticsUpdate(); //  Ensure statistics are up-to-date
        String[] v = new String[Statistics.values().length];

        /*  Assign the statistics values to the appropriate entry. The order
            of the assignments does not matter--the ordinal serves to get the
            values into the matching order with the labels from the enumeration. */
        v[Statistics.Size.ordinal()] = Integer.toString(size());
        v[Statistics.Length.ordinal()] = Integer.toString(length());
        v[Statistics.Cardinality.ordinal()] = Integer.toString(cardinality());
        v[Statistics.Total_words.ordinal()] = Integer.toString(cache.count);
        v[Statistics.Set_array_length.ordinal()] = Integer.toString(bits.length);
        v[Statistics.Set_array_max_length.ordinal()] =
                Integer.toString(MAX_LENGTH1);
        v[Statistics.Level2_areas.ordinal()] = Integer.toString(cache.a2Count);
        v[Statistics.Level2_area_length.ordinal()] = Integer.toString(LENGTH2);
        v[Statistics.Level3_blocks.ordinal()] = Integer.toString(cache.a3Count);
        v[Statistics.Level3_block_length.ordinal()] = Integer.toString(LENGTH3);
        v[Statistics.Compaction_count_value.ordinal()] =
                Integer.toString(compactionCount);

        /*  Determine the longest label, so that the equal signs may be lined-up. */
        int longestLabel = 0;
        for (Statistics s : Statistics.values())
            longestLabel =
                    Math.max(longestLabel, s.name().length());

        /*  Build a String that has for each statistic, the name of the statistic,
            padding, and equals sign, and the value. The "Load_factor_value",
            "Average_length_value", and "Average_chain_length" are printed as
            floating point values. */
        final StringBuilder result = new StringBuilder();
        for (Statistics s : Statistics.values())
        {
            result.append(s.name()); // The name of the statistic
            for (int i = 0; i != longestLabel - s.name().length(); ++i)
                result.append(' '); //  Fill out the field
            result.append(" = "); //  Show an equals sign
            result.append(v[s.ordinal()]); // and a value
            result.append('\n');
        }
        /*  Remove the underscores. */
        for (int i = 0; i != result.length(); ++i)
            if (result.charAt(i) == '_')
                result.setCharAt(i, ' ');

        if (values != null)
        {
            final int len = Math.min(values.length, v.length);
            System.arraycopy(v, 0, values, 0, len);
        }
        return result.toString();
    }

    /**
     *  Returns a string representation of this bit set. For every index for which
     *  this <code>SparseBitSet</code> contains a bit in the set state, the decimal
     *  representation of that index is included in the result. Such indices are
     *  listed in order from lowest to highest. If there is a subsequence of set
     *  bits longer than the value given by toStringCompaction, the subsequence
     *  is represented by the value for the first and the last values, with ".."
     *  between them. The individual bits, or the representation of sub-sequences
     *  are separated by ",&nbsp;" (a comma and a space) and surrounded by braces,
     *  resulting in a compact string showing (a variant of) the usual mathematical
     *  notation for a set of integers.
     *  <br>
     *  Example (with the default value of 2 for subsequences):
     *  <pre>
     *      SparseBitSet drPepper = new SparseBitSet();
     *  </pre>
     *  Now <code>drPepper.toString()</code> returns "<code>{}</code>".
     *  <br>
     *  <pre>
     *      drPepper.set(2);
     *  </pre>
     *  Now <code>drPepper.toString()</code> returns "<code>{2}</code>".
     *  <br>
     *  <pre>
     *      drPepper.set(3, 4);
     *      drPepper.set(10);
     *  </pre>
     *  Now <code>drPepper.toString()</code> returns "<code>{2..4, 10}</code>".
     *  <br>
     *  This method is intended for diagnostic use (as it is relatively expensive
     *  in time), but can be useful in interpreting problems in an application's use
     *  of a <code>SparseBitSet</code>.
     *
     * @return      a String representation of this SparseBitSet
     * @see         #toStringCompaction(int length)
     * @since       1.6
     */
    @Override
    public String toString()
    {
        final StringBuilder p = new StringBuilder(200);
        p.append('{');
        int i = nextSetBit(0);
        /*  Loop so long as there is another bit to append to the String. */
        while (i >= 0)
        {
            /*  Append that next bit */
            p.append(i);
            /*  Find the position of the next bit to show. */
            int j = nextSetBit(i + 1);
            if (compactionCount > 0)
            {
                /*  Give up if there is no next bit to show. */
                if (j < 0)
                    break;
                /*  Find the next clear bit is after the current bit, i.e., i */
                int last = nextClearBit(i);
                /*  Compute the position of the next clear bit after the current
                    subsequence of set bits. */
                last = (last < 0 ? Integer.MAX_VALUE : last);
                /*  If the subsequence is more than the specified bits long, then
                    collapse the subsequence into one entry in the String. */
                if (i + compactionCount < last)
                {
                    p.append("..").append(last - 1);
                    /*  Having accounted for a subsequence of bits that are all set,
                        recompute the label of the next bit to show. */
                    j = nextSetBit(last);
                }
            }
            /*  If there is another set bit, put a comma and a space after the
                last entry in the String.  */
            if (j >= 0)
                p.append(", ");
            /*  Transfer to i the index of the next set bit. */
            i = j;
        }
        /*  Terminate the representational String, and return it. */
        p.append('}');
        return p.toString();
    }

    /** Sequences of set bits longer than this value are shown by
     *  {@link #toString()} as a "sub-sequence," in the form <code>a..b</code>.
     *  Setting this value to zero causes each set bit to be listed individually.
     *  The default default value is 2 (which means sequences of three or more
     *  bits set are shown as a subsequence, and all other set bits are listed
     *  individually).
     *  <p>
     *  Note: this value will be passed to <code>SparseBitSet</code>s that
     *  may be created within or as a result of the operations on this bit set,
     *  or, for static methods, from the value belonging to the first parameter.
     *
     * @param       count the maximum count of a run of bits that are shown as
     *              individual entries in a <code>toString</code>() conversion.
     *              If 0, all bits are shown individually.
     * @since       1.6
     * @see         #toString()
     */
    public void toStringCompaction(int count)
    {
        compactionCount = count;
    }

    /**
     *  If <i>change</i> is <code>true</code>, the current value of the
     *  <i>toStringCompaction</i>() value is made the default value for all
     *  <code>SparseBitSet</code>s created from this point onward in this JVM.
     *
     * @param       change if true, change the default value
     * @since       1.6
     */
    public void toStringCompaction(boolean change)
    {
        /*  This is an assignment to a static value: the integer value assignment
            is atomic, so there will not be a partial store. If multiple
            invocations are made from multiple threads, there is a race
            condition that cannot be resolved by synchronization. */
        if (change)
            compactionCountDefault = compactionCount;
    }

    /**
     *  Performs a logical <b>XOR</b> of the addressed target bit with the
     *  argument value. This bit set is modified so that the addressed bit has the
     *  value <code>true</code> if and only one of the following statements holds:
     *  <ul>
     *  <li>The addressed bit initially had the value <code>true</code>, and the
     *      value of the argument is <code>false</code>.
     *  <li>The bit initially had the value <code>false</code>, and the
     *      value of the argument is <code>true</code>.
     * </ul>
     *
     * @param       i a bit index
     * @param       value a boolean value to <b>XOR</b> with that bit
     * @exception   java.lang.IndexOutOfBoundsException if the specified index
     *              is negative
     *              or equal to Integer.MAX_VALUE
     * @since       1.6
     */
    public void xor(int i, boolean value)
    {
        if ((i + 1) < 1)
            throw new IndexOutOfBoundsException("i=" + i);
        if (value)
            flip(i);
    }

    /**
     *  Performs a logical <b>XOR</b> of this bit set with the bit set argument
     *  within the given range. This resulting bit set is computed so that a bit
     *  within the range in it has the value <code>true</code> if and only if one
     *  of the following statements holds:
     *  <ul>
     *  <li>The bit initially had the value <code>true</code>, and the
     *      corresponding bit in the argument set has the value <code>false</code>.
     *  <li>The bit initially had the value <code>false</code>, and the
     *      corresponding bit in the argument set has the value <code>true</code>.
     * </ul>
     *  Outside the range this set is not changed.
     *
     * @param       i index of the first bit to be included in the operation
     * @param       j index after the last bit to included in the operation
     * @param       b the SparseBitSet with which to perform the <b>XOR</b>
     *              operation with this SparseBitSet
     * @exception   IndexOutOfBoundsException if <code>i</code> is negative or
     *              equal to Integer.MAX_VALUE, or <code>j</code> is negative,
     *              or <code>i</code> is larger than <code>j</code>
     * @since       1.6
     */
    public void xor(int i, int j, SparseBitSet b) throws IndexOutOfBoundsException
    {
        setScanner(i, j, b, xorStrategy);
    }

    /**
     *  Performs a logical <b>XOR</b> of this bit set with the bit set argument.
     *  This resulting bit set is computed so that a bit in it has the value
     *  <code>true</code> if and only if one of the following statements holds:
     *  <ul>
     *  <li>The bit initially had the value <code>true</code>, and the
     *      corresponding bit in the argument set has the value <code>false</code>.
     *  <li>The bit initially had the value <code>false</code>, and the
     *      corresponding bit in the argument set has the value <code>true</code>.
     * </ul>
     *
     * @param       b the SparseBitSet with which to perform the <b>XOR</b>
     *              operation with thisSparseBitSet
     * @since       1.6
     */
    public void xor(SparseBitSet b)
    {
        setScanner(0, b.bitsLength, b, xorStrategy);
    }

    /**
     * Performs a logical <b>XOR</b> of the two given <code>SparseBitSet</code>s.
     *  The resulting bit set is created so that a bit in it has the value
     *  <code>true</code> if and only if one of the following statements holds:
     *  <ul>
     *  <li>A bit in the first argument has the value <code>true</code>, and the
     *      corresponding bit in the second argument has the value
     *      <code>false</code>.</li>
     *  <li>A bit in the first argument has the value <code>false</code>, and the
     *      corresponding bit in the second argument has the value
     *      <code>true</code>.</li></ul>
     *
     * @param       a a SparseBitSet
     * @param       b another SparseBitSet
     * @return      a new SparseBitSet representing the <b>XOR</b> of the two sets
     * @since       1.6
     */
    public static SparseBitSet xor(SparseBitSet a, SparseBitSet b)
    {
        final SparseBitSet result = a.clone();
        result.xor(b);
        return result;
    }

    //==============================================================================
    //      Internal methods
    //==============================================================================

    /**
     *  Throw the exception to indicate a range error. The <code>String</code>
     *  constructed reports all the possible errors in one message.
     *
     * @param       i lower bound for a operation
     * @param       j upper bound for a operation
     * @exception   IndexOutOfBoundsException indicating the range is not valid
     * @since       1.6
     */
    protected static void throwIndexOutOfBoundsException(int i, int j)
            throws IndexOutOfBoundsException
    {
        String s = "";
        if (i < 0)
            s += "(i=" + i + ") < 0";
        if (i == Integer.MAX_VALUE)
            s += "(i=" + i + ")";
        if (j < 0)
            s += (s.isEmpty() ? "" : ", ") + "(j=" + j + ") < 0";
        if (i > j)
            s += (s.isEmpty() ? "" : ", ") + "(i=" + i + ") > (j=" + j + ")";
        throw new IndexOutOfBoundsException(s);
    }

    /**
     *  Intializes all the additional objects required for correct operation.
     *
     * @since       1.6
     */
    protected final void constructorHelper()
    {
        spare = new long[LENGTH3];
        cache = new Cache();
        updateStrategy = new UpdateStrategy();
    }

    /**
     *  Clear out a part of the set array with nulls, from the given start to the
     *  end of the array. If the given parameter is beyond the end of the bits
     *  array, nothing is changed.
     *
     * @param       start word index at which to start (inclusive)
     * @since       1.6
     */
    protected final void nullify(int start)
    {
        final int aLength = bits.length;
        if (start < aLength)
        {
            for (int w = start; w != aLength; ++w)
                bits[w] = null;
            cache.hash = 0; //  Invalidate size, etc., values
        }
    }

    /**
     *  Resize the bit array. Moves the entries in the the bits array of this
     *  SparseBitSet into an array whose size (which may be larger or smaller) is
     *  the given bit size (<i>i.e.</i>, includes the bit whose index is one less
     *  that the given value). If the new array is smaller, the excess entries in
     *  the set array are discarded. If the new array is bigger, it is filled with
     *  nulls.
     *
     * @param       index the desired address to be included in the set
     * @since       1.6
     */
    protected final void resize(int index)
    {
        /*  Find an array size that is a power of two that is as least as large
            enough to contain the index requested. */
        final int w1 = (index >> SHIFT3) >> SHIFT1;
        int newSize = Integer.highestOneBit(w1);
        if (newSize == 0)
            newSize = 1;
        if (w1 >= newSize)
            newSize <<= 1;
        if (newSize > MAX_LENGTH1)
            newSize = MAX_LENGTH1;
        final int aLength1 = (bits != null ? bits.length : 0);

        if (newSize != aLength1 || bits == null)
        { // only if the size needs to be changed
            final long[][][] temp = new long[newSize][][]; //  Get the new array
            if (aLength1 != 0)
            {
                /*  If it exists, copy old array to the new array. */
                System.arraycopy(bits, 0, temp, 0, Math.min(aLength1, newSize));
                nullify(0); //  Don't leave unused pointers around. */
            }
            bits = temp; //  Set new array as the set array
            bitsLength = //  Index of last possible bit, plus one.
                    (newSize == MAX_LENGTH1 ? Integer.MAX_VALUE : newSize * UNIT);
        }
    }

    /**
     *  Scans over the bit set (and a second bit set if part of the operation) are
     *  all performed by this method. The properties and the operation executed
     *  are defined by a given strategy, which must be derived from the
     *  <code>AbstractStrategy</code>. The strategy defines how to operate on a
     *  single word, and on whole words that may or may not constitute a full
     *  block of words.
     *
     * @param       i the bit (inclusive) at which to start the scan
     * @param       j the bit (exclusive) at which to stop the scan
     * @param       b a SparseBitSet, if needed, the second SparseBitSet in the
     *              operation
     * @param       op the AbstractStrategy class defining the operation to be
     *              executed
     * @exception   IndexOutOfBoundsException
     * @since       1.6
     * @see         AbstractStrategy
     */
    protected final void setScanner(int i, int j, SparseBitSet b,
                                    AbstractStrategy op) throws IndexOutOfBoundsException
    {
        /*  This method has been assessed as having a McCabe cyclomatic
            complexity of 47 (i.e., impossibly high). However, given that this
            method incorporates all the set scanning logic for all methods
            (with the exception of nextSetBit and nextClearBit, which themselves
            have high cyclomatic complexities of 13), and is attempting to minimise
            execution time (hence deals with processing shortcuts), it cannot be
            expected to be simple. In fact, the work of lining up level3 blocks
            proceeds step-wise, and each sub-section piece is reasonably
            straight-forward. Nevertheless, the number of paths is high, and
            caution is advised in attempting to correct anything. */

        /*  Do whatever the strategy needs to get started, and do whatever initial
            checking is needed--fail here if needed before much else is done. */
        if (op.start(b))
            cache.hash = 0;

        if (j < i || (i + 1) < 1)
            throwIndexOutOfBoundsException(i, j);
        if (i == j)
            return;

        /*  Get the values of all the short-cut options. */
        final int properties = op.properties();
        final boolean f_op_f_eq_f = (properties & AbstractStrategy.F_OP_F_EQ_F) != 0;
        final boolean f_op_x_eq_f = (properties & AbstractStrategy.F_OP_X_EQ_F) != 0;
        final boolean x_op_f_eq_f = (properties & AbstractStrategy.X_OP_F_EQ_F) != 0;
        final boolean x_op_f_eq_x = (properties & AbstractStrategy.X_OP_F_EQ_X) != 0;

        /*  Index of the current word, and mask for the first word,
            to be processed in the bit set. */
        int u = i >> SHIFT3;
        final long um = ~0L << i;

        /*  Index of the final word, and mask for the final word,
            to be processed in the bit set. */
        final int v = (j - 1) >> SHIFT3;
        final long vm = ~0L >>> -j;

        /*  Set up the two bit arrays (if the second exists), and their
            corresponding lengths (if any). */
        long[][][] a1 = bits; //  Level1, i.e., the bit arrays
        int aLength1 = bits.length;
        final long[][][] b1 = (b != null ? b.bits : null);
        final int bLength1 = (b1 != null ? b.bits.length : 0);

        /*  Calculate the initial values of the parts of the words addresses,
            as well as the location of the final block to be processed.  */
        int u1 = u >> SHIFT1;
        int u2 = (u >> SHIFT2) & MASK2;
        int u3 = u & MASK3;
        final int v1 = v >> SHIFT1;
        final int v2 = (v >> SHIFT2) & MASK2;
        final int v3 = v & MASK3;
        final int lastA3Block = (v1 << LEVEL2) + v2;

        /*  Initialize the local copies of the counts of blocks and areas; and
            whether there is a partial first block.  */
        int a2CountLocal = 0;
        int a3CountLocal = 0;
        boolean notFirstBlock = u == 0 && um == ~0L;

        /*  The first level2 is cannot be judged empty if not being scanned from
            the beginning. */
        boolean a2IsEmpty = u2 == 0; //  Presumption
        while (i < j)
        {
            /*  Determine if there is a level2 area in both the a and the b set,
                and if so, set the references to these areas. */
            long[][] a2 = null;
            boolean haveA2 = u1 < aLength1 && (a2 = a1[u1]) != null;
            long[][] b2 = null;
            final boolean haveB2 = u1 < bLength1
                    && b1 != null && (b2 = b1[u1]) != null;
            /*  Handling of level 2 empty areas: determined by the
                properties of the strategy. It is necessary to actually visit
                the first and last blocks of a scan, since not all of the block
                might participate in the operation, hence making decision based
                on just the references to the blocks could be wrong. */
            if ((!haveA2 && !haveB2 && f_op_f_eq_f
                    || !haveA2 && f_op_x_eq_f || !haveB2 && x_op_f_eq_f)
                    && notFirstBlock && u1 != v1)
            {//nested if!
                if (u1 < aLength1)
                    a1[u1] = null;
            }
            else
            {
                final int limit2 = (u1 == v1 ? v2 + 1 : LENGTH2);
                while (u2 != limit2)
                {
                    /*  Similar logic applied here as for the level2 blocks.
                        The initial and final block must be examined. In other
                        cases, it may be possible to make a decision based on
                        the value of the references, as indicated by the
                        properties of the strategy. */
                    long[] a3 = null;
                    final boolean haveA3 = haveA2 && (a3 = a2[u2]) != null;
                    long[] b3 = null;
                    final boolean haveB3 = haveB2 && (b3 = b2[u2]) != null;
                    final int a3Block = (u1 << LEVEL2) + u2;
                    final boolean notLastBlock = lastA3Block != a3Block;
                    /*  Handling of level 3 empty areas: determined by the
                        properties of the strategy. */
                    if ((!haveA3 && !haveB3 && f_op_f_eq_f
                            || !haveA3 && f_op_x_eq_f || !haveB3 && x_op_f_eq_f)
                            && notFirstBlock && notLastBlock)
                    {
                        /*  Do not need level3 block, so remove it, and move on. */
                        if (haveA2)
                            a2[u2] = null;
                    }
                    else
                    {
                        /*  So what is needed is the level3 block. */
                        final int base3 = a3Block << SHIFT2;
                        final int limit3 = (notLastBlock ? LENGTH3 : v3);
                        if (!haveA3)
                            a3 = spare;
                        if (!haveB3)
                            b3 = ZERO_BLOCK;
                        boolean isZero;
                        if (notFirstBlock && notLastBlock)
                            if (x_op_f_eq_x && !haveB3)
                                isZero = op.isZeroBlock(a3);
                                // b block is null, just check a block
                            else
                                isZero = op.block(base3, 0, LENGTH3, a3, b3);
                            // Do the operation on the whole block
                        else
                        { /*  Partial block to process. */
                            if (notFirstBlock)
                            {
                                /*  By implication, this is the last block */
                                isZero = op.block(base3, 0, limit3, a3, b3);
                                //  Do the whole words
                                isZero &= op.word(base3, limit3, a3, b3, vm);
                                //  And then the final word
                            }
                            else
                            { // u, v are correct if first block
                                if (u == v) //  Scan starts and ends in one word
                                    isZero = op.word(base3, u3, a3, b3, um & vm);
                                else
                                { // Scan starts in this a3 block
                                    isZero = op.word(base3, u3, a3, b3, um);
                                    //  First word
                                    isZero &=
                                            op.block(base3, u3 + 1, limit3, a3, b3);
                                    //  Remainder of full words in block
                                    if (limit3 != LENGTH3)
                                        isZero &= op.word(base3, limit3, a3, b3, vm);
                                    //  If there is a partial word left
                                }
                                notFirstBlock = true; //  Only one first block
                            }
                            if (isZero)
                                isZero = op.isZeroBlock(a3);
                            // If not known to have a non-zero
                            // value, be sure whether all zero.
                        }
                        if (isZero) //  The resulting a3 block has no values
                        {// nested if!
                            /*  If there is an level 2 area make the entry for this
                                level3 block be a null (i.e., remove any a3 block ). */
                            if (haveA2)
                                a2[u2] = null;
                        }
                        else
                        {
                            /*  If the a3 block used was the spare block, put it
                                into current level2 area; get a new spare block. */
                            if (a3 == spare)
                            {
                                if (i >= bitsLength) //Check that the set is large
                                { //  enough to take the new block
                                    resize(i); //  Make it large enough
                                    a1 = bits; //  Update reference and length
                                    aLength1 = a1.length;
                                }
                                if (a2 == null) //  Ensure a level 2 area
                                {
                                    a1[u1] = a2 = new long[LENGTH2][];
                                    haveA2 = true; //  Ensure know level2 not empty
                                }
                                a2[u2] = a3; //  Insert the level3 block
                                spare = new long[LENGTH3]; // Replace the spare
                            }
                            ++a3CountLocal; // Count the level 3 block
                        }
                        a2IsEmpty &= !(haveA2 && a2[u2] != null);
                    } //  Keep track of level 2 usage
                    ++u2;
                    u3 = 0;
                } /* end while ( u2 != limit2 ) */
                /*  If the loop finishes without completing the level 2, it may
                    be left with a reference but still be all null--this is OK. */
                if (u2 == LENGTH2 && a2IsEmpty && u1 < aLength1)
                    a1[u1] = null;
                else
                    ++a2CountLocal; //  Count level 2 areas
            }
            /*  Advance the value of u based on what happened. */
            i = (u = (++u1 << SHIFT1)) << SHIFT3;
            u2 = 0; //  u3 = 0
            //  Compute next word and bit index
            if (i < 0)
                i = Integer.MAX_VALUE; //  Don't go over the end
        } /* end while( i < j ) */

        /*  Do whatever the strategy needs in order to finish. */
        op.finish(a2CountLocal, a3CountLocal);
    }

    /**
     *  The entirety of the bit set is examined, and the various statistics of
     *  the bit set (size, length, cardinality, hashCode, etc.) are computed. Level
     *  arrays that are empty (i.e., all zero at level 3, all null at level 2) are
     *  replaced by null references, ensuring a normalized representation.
     *
     * @since       1.6
     */
    protected final void statisticsUpdate()
    {
        if (cache.hash != 0)
            return;
        setScanner(0, bitsLength, null, updateStrategy);
    }

    //==============================================================================
    //  Serialization/Deserialization methods
    //==============================================================================

    /**
     *  Save the state of the <code>SparseBitSet</code> instance to a stream
     *  (<i>i.e.</i>, serialize it).
     *
     * @param       s the ObjectOutputStream to which to write the serialized object
     * @exception   java.io.IOException if an io error occurs
     * @exception   java.lang.InternalError if the SparseBitSet representation is
     *              inconsistent
     *
     * @serialData  The default data is emitted, followed by the current
     *              <i>compactionCount</i> for the bit set, and then the
     *              <i>length</i> of the set (the position of the last bit),
     *              followed by the <i>cache.count</i> value (an <code>int</code>,
     *              the number of <code>int-&gt;long</code> pairs needed to describe
     *              the set), followed by the index (<code>int</code>) and word
     *              (<code>long</code>) for each <code>int-&gt;long</code> pair.
     *              The mappings need not be emitted in any particular order. This
     *              is followed by the <i>hashCode</i> for the set that can be used
     *              as an integrity check when the bit set is read back.
     *
     * @since       1.6
     */
    private void writeObject(ObjectOutputStream s) throws IOException, InternalError
    {
        statisticsUpdate(); //  Update structure and stats if needed.
        /*  Write any hidden stuff. */
        s.defaultWriteObject();
        s.writeInt(compactionCount); //  Needed to preserve value
        s.writeInt(cache.length); //  Needed to know where last bit is

        /*  This is the number of index/value pairs to be written. */
        int count = cache.count; //  Minimum number of words to be written
        s.writeInt(count);
        final long[][][] a1 = bits;
        final int aLength1 = a1.length;
        long[][] a2;
        long[] a3;
        long word;
        for (int w1 = 0; w1 != aLength1; ++w1)
            if ((a2 = a1[w1]) != null)
                for (int w2 = 0; w2 != LENGTH2; ++w2)
                    if ((a3 = a2[w2]) != null)
                    {
                        final int base = (w1 << SHIFT1) + (w2 << SHIFT2);
                        for (int w3 = 0; w3 != LENGTH3; ++w3)
                            if ((word = a3[w3]) != 0)
                            {
                                s.writeInt(base + w3);
                                s.writeLong(word);
                                --count;
                            }
                    }
        if (count != 0)
            throw new InternalError("count of entries not consistent");
        /*  As a consistency check, write the hash code of the set. */
        s.writeInt(cache.hash);
    }

    /**
     *  serialVersionUID
     */
    private static final long serialVersionUID = -6663013367427929992L;

    /**
     *  Reconstitute the <code>SparseBitSet</code> instance from a stream
     *  (<i>i.e.</i>, deserialize it).
     *
     * @param       s the ObjectInputStream to use
     * @exception   IOException if there is an io error
     * @exception   ClassNotFoundException if the stream contains an unidentified
     *              class
     * @since       1.6
     */
    private void readObject(ObjectInputStream s) throws IOException,
            ClassNotFoundException
    {
        /* Read in any hidden stuff that is part of the class overhead. */
        s.defaultReadObject();
        compactionCount = s.readInt();
        final int aLength = s.readInt();
        resize(aLength); // Make sure there is enough space

        /* Read in number of mappings. */
        final int count = s.readInt();
        /*  Read the keys and values, them into the set array, areas, and blocks. */
        long[][] a2;
        long[] a3;
        for (int n = 0; n != count; ++n)
        {
            final int w = s.readInt();
            final int w3 = w & MASK3;
            final int w2 = (w >> SHIFT2) & MASK2;
            final int w1 = w >> SHIFT1;

            final long word = s.readLong();
            if ((a2 = bits[w1]) == null)
                a2 = bits[w1] = new long[LENGTH2][];
            if ((a3 = a2[w2]) == null)
                a3 = a2[w2] = new long[LENGTH3];
            a3[w3] = word;
        }
        /* Ensure all the pieces are set up for set scanning. */
        constructorHelper();
        statisticsUpdate();
        if (count != cache.count)
            throw new InternalError("count of entries not consistent");
        final int hash = s.readInt(); //  Get the hashcode that was stored
        if (hash != cache.hash) //  An error of some kind if not the same
            throw new IOException("deserialized hashCode mis-match");
    }

    //=============================================================================
    //  Statistics enumeration
    //=============================================================================

    /**
     *  These enumeration values are used as labels for the values in the String
     *  created by the <i>statistics</i>() method. The values of the corresponding
     *  statistics are <code>int</code>s, except for the loadFactor and
     *  Average_chain_length values, which are <code>float</code>s.
     *  <p>
     *  An array of <code>String</code>s may be obtained containing a
     *  representation of each of these values. An element of such an array, say,
     *  <code>values</code>, may be accessed, for example, by:
     *  <pre>
     *      values[SparseBitSet.statistics.Buckets_available.ordinal()]</pre>
     *
     * @see         #statistics(String[])
     */
    public enum Statistics
    {
        /**
         *  The size of the bit set, as give by the <i>size</i>() method.
         */
        Size, // 0
        /**
         *  The length of the bit set, as give by the <i>length</i>() method.
         */
        Length, // 1
        /**
         *  The cardinality of the bit set, as give by the <i>cardinality</i>() method.
         */
        Cardinality, // 2
        /**
         *  The total number of non-zero 64-bits "words" being used to hold the
         *  representation of the bit set.
         */
        Total_words, // 3
        /**
         *  The length of the bit set array.
         */
        Set_array_length, // 4
        /**
         *  The maximum permitted length of the bit set array.
         */
        Set_array_max_length, // 5
        /**
         *  The number of level2 areas.
         */
        Level2_areas, // 6
        /**
         *  The length of the level2 areas.
         */
        Level2_area_length, // 7
        /**
         *  The total number of level3 blocks in use.
         */
        Level3_blocks, // 8
        /**
         *  The length of the level3 blocks.
         */
        Level3_block_length, // 9
        /**
         *  Is the value that determines how the <i>toString</i>() conversion is
         *  performed.
         * @see         #toStringCompaction(int)
         */
        Compaction_count_value // 10
    }

    //=============================================================================
    //  A set of cached statistics values, recomputed when necessary
    //=============================================================================

    /**
     *  This class holds the values related to various statistics kept about the
     *  bit set. These values are not kept continuously up-to-date. Whenever the
     *  values become invalid, the field <i>hash</i> is set to zero, indicating
     *  that an update is required.
     *
     * @see     #statisticsUpdate()
     */
    protected class Cache
    {
        /**
         *  <i>hash</i> is updated by the <i>statisticsUpdate</i>() method.
         *  If the <i>hash</i> value is zero, it is assumed that <b><i>all</i></b>
         *  the cached values are stale, and must be updated.
         */
        protected transient int hash;

        /**
         *  <i>size</i> is updated by the <i>statisticsUpdate</i>() method.
         *  If the <i>hash</i> value is zero, it is assumed the all the cached
         *  values are stale, and must be updated.
         */
        protected transient int size;

        /**
         *  <i>cardinality</i> is updated by the <i>statisticsUpdate</i>() method.
         *  If the <i>hash</i> value is zero, it is assumed the all the cached
         *  values are stale, and must be updated.
         */
        protected transient int cardinality;

        /**
         *  <i>length</i> is updated by the <i>statisticsUpdate</i>() method.
         *  If the <i>hash</i> value is zero, it is assumed the all the cached
         *  values are stale, and must be updated.
         */
        protected transient int length;

        /**
         *  <i>count</i> is updated by the <i>statisticsUpdate</i>() method.
         *  If the <i>hash</i> value is zero, it is assumed the all the cached
         *  values are stale, and must be updated.
         */
        protected transient int count;

        /**
         *  <i>a2Count</i> is updated by the <i>statisticsUpdate</i>()
         *  method, and will only be correct immediately after a full update. The
         *  <i>hash</i> value is must be zero for all values to be updated.
         */
        protected transient int a2Count;

        /**
         *  <i>a3Count</i> is updated by the <i>statisticsUpdate</i>() method,
         *  and will only be correct immediately after a full update. The
         *  <i>hash</i> value is must be zero for all values to be updated.
         */
        protected transient int a3Count;
    }

    //=============================================================================
    //  Abstract Strategy super-class for Strategies describing logical operations
    //=============================================================================

    /**
     *  This strategy class is used by the setScanner to carry out the a variety
     *  of operations on this set, and usually a second set. The
     *  <i>setScanner</i>() method of the main <code>SparseBitSet</code> class
     *  essentially finds matching level3 blocks, and then calls the strategy to
     *  do the appropriate operation on each of the elements of the block.
     *  <p>
     *  The symbolic constants control optimisation paths in the
     *  <i>setScanner</i>() method of the main <code>SparseBitSet</code> class.
     *
     *  @see SparseBitSet#setScanner(int i, int j,
     *                          SparseBitSet b, AbstractStrategy op)
     */
    protected abstract static class AbstractStrategy
    {
        /** If the operation requires that when matching level2 areas or level3
         *  blocks are null, that no action is required, then this property is
         *  required. Corresponds to the top-left entry in the logic diagram for the
         *  operation being 0. For all the defined actual logic operations ('and',
         *  'andNot', 'or', and 'xor', this will be true, because for all these,
         *  "false" op "false" = "false".
         */
        static final int F_OP_F_EQ_F = 0x1;

        /** If when level2 areas or level3 areas from the this set are null will
         *  require that area or block to remain null, irrespective of the value of
         *  the matching structure from the other set, then this property is required.
         *  Corresponds to the first row in the logic diagram being all zeros. For
         *  example, this is true for 'and' as well as 'andNot', and for 'clear', since
         *  false" & "x" = "false", and "false" &! "x" = "false".
         */
        static final int F_OP_X_EQ_F = 0x2;

        /** If when level2 areas or level3 areas from the other set are null will
         *  require the matching area or block in this set to be set to null,
         *  irrespective of the current values in the matching structure from the
         *  this, then this property is required. Corresponds to the first column
         *  in the logic diagram being all zero. For example, this is true for
         *  'and', since "x" & "false" = "false", as well as for 'clear'.
         */
        static final int X_OP_F_EQ_F = 0x4;

        /** If when a level3 area from the other set is null will require the
         *  matching area or block in this set to be left as it is, then this property
         *  is required. Corresponds to the first column of the logic diagram being
         *  equal to the left hand operand column. For example, this is true for 'or',
         *  'xor', and 'andNot', since for all of these "x" op "false" = "x".
         */
        static final int X_OP_F_EQ_X = 0x8;

        /**
         *  Properties of this strategy.
         *
         * @return      the int containing the bits representing the properties of
         *              this strategy
         * @since       1.6
         */
        protected abstract int properties();

        /**
         *  Instances of this class are to be serially reusable. To start a
         *  particular use, an instance is (re-)started by calling this method. It is
         *  passed the reference to the other bit set (usually to allow a check on
         *  whether it is null or not, so as to simplify the implementation of the
         *  <i>block</i>() method.
         *
         * @param       b the "other" set, for whatever checking is needed.
         * @since       1.6
         * @return      true -> if the cache should be set to zero
         */
        protected abstract boolean start(SparseBitSet b);

        /**
         *  Deal with a scan that include a partial word within a level3 block. All
         *  that is required is that the result be stored (if needed) into the
         *  given a set block at the correct position, and that the operation only
         *  affect those bits selected by 1 bits in the mask.
         *
         * @param       base the base index of the block (to be used if needed)
         * @param       u3 the index of the word within block
         * @param       a3 the level3 block from the <i>a</i> set.
         * @param       b3 the (nominal) level3 block from the <i>b</i> set (not null).
         * @param       mask for the (partial) word
         * @return      true if the resulting word is zero
         * @since       1.6
         */
        protected abstract boolean word(int base, int u3, long[] a3, long[] b3, long mask);

        /**
         *  Deals with a part of a block that consists of whole words, starting with
         *  the given first index, and ending with the word before the last index.
         *  For the words processed, the return value should indicate whether all those
         *  resulting words were zero, or not.
         *
         * @param       base the base index of the block (to be used if needed)
         * @param       u3 the index of the first word within block to process
         * @param       v3 the index of the last word, which may be within block
         * @param       a3 the level3 block from the <i>a</i> set.
         * @param       b3 the (nominal) level3 block from the <i>b</i> set (not null).
         * @return      true if the words scanned within the level3 block were all zero
         * @since       1.6
         */
        protected abstract boolean block(int base, int u3, int v3, long[] a3, long[] b3);

        /**
         *  This is called to finish the processing started by the strategy (if there
         *  needs to be anything done at all).
         *
         * @param       a2Count possible count of level2 areas in use
         * @param       a3Count possible count of level3 blocks in use
         * @since       1.6
         */
        protected void finish(int a2Count, int a3Count)
        {
        }

        /**
         *  Check whether a level3 block is all zero.
         *
         * @param       a3 the block from the <i>a</i> set
         * @return      true if the values of the level3 block are all zero
         *
         * @since       1.6
         */
        protected final boolean isZeroBlock(long[] a3)
        {
            for (long word : a3)
                if (word != 0L)
                    return false;
            return true;
        }
    }

    //=============================================================================
    //  Strategies based on the Strategy super-class describing logical operations
    //=============================================================================

    /**
     *  And of two sets. Where the <i>a</i> set is zero, it remains zero (i.e.,
     *  without entries or with zero words). Similarly, where the <i>b</i> set is
     *  zero, the <i>a</i> becomes zero (i.e., without entries).
     *  <p>
     *  If level1 of the <i>a</i> set is longer than level1 of the bit set
     *  <i>b</i>, then the unmatched virtual "entries" of the <i>b</i> set (beyond
     *  the actual length of <i>b</i>) corresponding to these are all false, hence
     *  the result of the "and" operation will be to make all these entries in this
     *  set to become false--hence just remove them, and then scan only those
     *  entries that could match entries in the bit set<i>b</i>. This clearing of
     *  the remainder of the <i>a</i> set is accomplished by selecting both
     *  <i>F_OP_X_EQ_F</i> and <i>X_OP_F_EQ_F</i>.
     *
     *  <pre>
     *  and| 0 1
     *    0| 0 0
     *    1| 0 1 <pre>
     */
    protected static class AndStrategy extends AbstractStrategy
    {
        @Override
        //  AndStrategy
        protected int properties()
        {
            return F_OP_F_EQ_F + F_OP_X_EQ_F + X_OP_F_EQ_F;
        }

        @Override
        //  AndStrategy
        protected boolean start(SparseBitSet b)
        {
            if (b == null)
                throw new NullPointerException();
            return true;
        }

        @Override
        //  AndStrategy
        protected boolean word(int base, int u3, long[] a3, long[] b3, long mask)
        {
            return (a3[u3] &= b3[u3] | ~mask) == 0L;
        }

        @Override
        //  AndStrategy
        protected boolean block(int base, int u3, int v3, long[] a3, long[] b3)
        {
            boolean isZero = true; //  Presumption
            for (int w3 = u3; w3 != v3; ++w3)
                isZero &= ((a3[w3] &= b3[w3]) == 0L);
            return isZero;
        }
    }

    //-----------------------------------------------------------------------------
    /**
     *  AndNot of two sets. Where the <i>a</i> set is zero, it remains zero
     *  (i.e., without entries or with zero words). On the other hand, where the
     *  <i>b</i> set is zero, the <i>a</i> remains unchanged.
     *  <p>
     *  If level1 of the <i>a</i> set is longer than level1 of the bit set
     *  <i>b</i>, then the unmatched virtual "entries" of the <i>b</i> set (beyond
     *  the actual length of <i>b</i>) corresponding to these are all false, hence
     *  the result of the "and" operation will be to make all these entries in this
     *  set to become false--hence just remove them, and then scan only those
     *  entries that could match entries in the bit set<i>b</i>. This clearing of
     *  the remainder of the <i>a</i> set is accomplished by selecting both
     *  <i>F_OP_X_EQ_F</i> and <i>X_OP_F_EQ_F</i>.
     *
     *  <pre>
     * andNot| 0 1
     *      0| 0 0
     *      1| 1 0 <pre>
     */
    protected static class AndNotStrategy extends AbstractStrategy
    {
        @Override
        //  AndNotStrategy
        protected int properties()
        {
            return F_OP_F_EQ_F + F_OP_X_EQ_F + X_OP_F_EQ_X;
        }

        @Override
        //  AndNotStrategy
        protected boolean start(SparseBitSet b)
        {
            if (b == null)
                throw new NullPointerException();
            return true;
        }

        @Override
        //  AndNotStrategy
        protected boolean word(int base, int u3, long[] a3, long[] b3, long mask)
        {
            return (a3[u3] &= ~(b3[u3] & mask)) == 0L;
        }

        @Override
        //  AndNotStrategy
        protected boolean block(int base, int u3, int v3, long[] a3, long[] b3)
        {
            boolean isZero = true; //  Presumption
            for (int w3 = u3; w3 != v3; ++w3)
                isZero &= (a3[w3] &= ~b3[w3]) == 0L;
            return isZero;
        }
    }

    //-----------------------------------------------------------------------------
    /**
     *  Clear clears bits in the <i>a</i> set.
     *
     * <pre>
     * clear| 0 1
     *     0| 0 0
     *     1| 0 0 <pre>
     */
    protected static class ClearStrategy extends AbstractStrategy
    {
        @Override
        //  ClearStrategy
        protected int properties()
        {
            return F_OP_F_EQ_F + F_OP_X_EQ_F;
        }

        @Override
        //  ClearStrategy
        protected boolean start(SparseBitSet b)
        {
            return true;
        }

        @Override
        //  ClearStrategy
        protected boolean word(int base, int u3, long[] a3, long[] b3, long mask)
        {
            return (a3[u3] &= ~mask) == 0L;
        }

        @Override
        //  ClearStrategy
        protected boolean block(int base, int u3, int v3, long[] a3, long[] b3)
        {
            if (u3 != 0 || v3 != LENGTH3) //  Optimisation
                for (int w3 = u3; w3 != v3; ++w3)
                    a3[w3] = 0L;
            return true;
        }
    }

    //-----------------------------------------------------------------------------
    /**
     *  Copies the needed parts of the <i>b</i> set to the <i>a</i> set.
     *
     * <pre>
     * get| 0 1
     *   0| 0 1
     *   1| 0 1 <pre>
     */
    protected static class CopyStrategy extends AbstractStrategy
    {
        @Override
        //  CopyStrategy
        protected int properties()
        {
            return F_OP_F_EQ_F + X_OP_F_EQ_F;
        }

        @Override
        //  CopyStrategy
        protected boolean start(SparseBitSet b)
        {
            return true;
        }

        @Override
        //  CopyStrategy
        protected boolean word(int base, int u3, long[] a3, long[] b3, long mask)
        {
            return (a3[u3] = b3[u3] & mask) == 0L;
        }

        @Override
        //  CopyStrategy
        protected boolean block(int base, int u3, int v3, long[] a3, long[] b3)
        {
            boolean isZero = true;
            for (int w3 = u3; w3 != v3; ++w3)
                isZero &= (a3[w3] = b3[w3]) == 0L;
            return isZero;
        }
    }

    //-----------------------------------------------------------------------------
    /**
     *  Equals compares bits in the <i>a</i> set with those in the <i>b</i> set.
     *  None of the values in either set are changed, although the <i>a</i> set
     *  may have all zero level 3 blocks replaced by null references (and
     *  similarly at level 2).
     *
     * <pre>
     * equals| 0 1
     *      0| 0 -
     *      1| - - <pre>
     */
    protected static class EqualsStrategy extends AbstractStrategy
    {
        boolean result; // Used to hold result of the comparison

        @Override
        //  EqualsStrategy
        protected int properties()
        {
            return F_OP_F_EQ_F;
        }

        @Override
        //  EqualsStrategy
        protected boolean start(SparseBitSet b)
        {
            if (b == null)
                throw new NullPointerException();
            result = true;
            return false;
            /*  Equals does not change the content of the set, hence hash need
                not be reset. */
        }

        @Override
        //  EqualsStrategy
        protected boolean word(int base, int u3, long[] a3, long[] b3, long mask)
        {
            final long word = a3[u3];
            result &= (word & mask) == (b3[u3] & mask);
            return word == 0L;
        }

        @Override
        //  EqualsStrategy
        protected boolean block(int base, int u3, int v3, long[] a3, long[] b3)
        {

            boolean isZero = true; //  Presumption
            for (int w3 = u3; w3 != v3; ++w3)
            {
                final long word = a3[w3];
                result &= word == b3[w3];
                isZero &= word == 0L;
            }
            return isZero;
        }
    }

    //-----------------------------------------------------------------------------
    /**
     *  Flip inverts the bits of the <i>a</i> set within the given range.
     *
     * <pre>
     * flip| 0 1
     *    0| 1 1
     *    1| 0 0 <pre>
     */
    protected static class FlipStrategy extends AbstractStrategy
    {
        @Override
        // FlipStrategy
        protected int properties()
        {
            return 0;
        }

        @Override
        // FlipStrategy
        protected boolean start(SparseBitSet b)
        {
            return true;
        }

        @Override
        // FlipStrategy
        protected boolean word(int base, int u3, long[] a3, long[] b3, long mask)
        {
            return (a3[u3] ^= mask) == 0L;
        }

        @Override
        // FlipStrategy
        protected boolean block(int base, int u3, int v3, long[] a3, long[] b3)
        {
            boolean isZero = true; //  Presumption
            for (int w3 = u3; w3 != v3; ++w3)
                isZero &= (a3[w3] ^= ~0L) == 0L;
            return isZero;
        }
    }

    //-----------------------------------------------------------------------------
    /**
     *  Intersect has a true result if any word in the <i>a</i> set has a bit
     *  in common with the <i>b</i> set. During the scan of the <i>a</i> set
     *  blocks (and areas) that are all zero may be replaced with empty blocks
     *  and areas (null references), but the value of the set is not changed
     *  (which is why X_OP_F_EQ_F is not selected, since this would cause
     *  parts of the <i>a</i> set to be zero-ed out).
     *
     * <pre>
     * intersect| 0 1
     *         0| 0 0
     *         1| 1 1 <pre>
     */
    protected static class IntersectsStrategy extends AbstractStrategy
    {
        /**
         *  The boolean result of the intersects scan Strategy is kept here.
         */
        protected boolean result;

        @Override
        //  IntersectsStrategy
        protected int properties()
        {
            return F_OP_F_EQ_F + F_OP_X_EQ_F;
        }

        @Override
        //  IntersectsStrategy
        protected boolean start(SparseBitSet b)
        {
            if (b == null)
                throw new NullPointerException();
            result = false;
            return false;
            /*  Intersect does not change the content of the set, hence hash
                need not be reset. */
        }

        @Override
        //  IntersectsStrategy
        protected boolean word(int base, int u3, long[] a3, long[] b3, long mask)
        {
            final long word = a3[u3];
            result |= (word & b3[u3] & mask) != 0L;
            return word == 0L;
        }

        @Override
        //  IntersectsStrategy
        protected boolean block(int base, int u3, int v3, long[] a3, long[] b3)
        {
            boolean isZero = true; //  Presumption
            for (int w3 = u3; w3 != v3; ++w3)
            {
                final long word = a3[w3];
                result |= (word & b3[w3]) != 0L;
                isZero &= word == 0L;
            }
            return isZero;
        }
    }

    /**
     *  Or of two sets. Where the <i>a</i> set is one, it remains one. Similarly,
     *  where the <i>b</i> set is one, the <i>a</i> becomes one. If both sets have
     *  zeros in corresponding places, a zero results. Whole blocks or areas that
     *  are or become zero are replaced by null arrays.
     *  <p>
     *  If level1 of the <i>a</i> set is longer than level1 of the bit set
     *  <i>b</i>, then the unmatched entries of the <i>a</i> set (beyond
     *  the actual length of <i>b</i>) corresponding to these remain unchanged. *
     *  <pre>
     *   or| 0 1
     *    0| 0 1
     *    1| 1 1 <pre>
     */
    protected static class OrStrategy extends AbstractStrategy
    {
        @Override
        //  OrStrategy
        protected int properties()
        {
            return F_OP_F_EQ_F + X_OP_F_EQ_X;
        }

        @Override
        //  OrStrategy
        protected boolean start(SparseBitSet b)
        {
            if (b == null)
                throw new NullPointerException();
            return true;
        }

        @Override
        //  OrStrategy
        protected boolean word(int base, int u3, long[] a3, long[] b3, long mask)
        {
            return (a3[u3] |= b3[u3] & mask) == 0L;
        }

        @Override
        //  OrStrategy
        protected boolean block(int base, int u3, int v3, long[] a3, long[] b3)
        {
            boolean isZero = true; //  Presumption
            for (int w3 = u3; w3 != v3; ++w3)
                isZero &= (a3[w3] |= b3[w3]) == 0L;
            return isZero;
        }
    }

    //-----------------------------------------------------------------------------
    /**
     *  Set creates entries everywhere within the range. Hence no empty level2
     *  areas or level3 blocks are ignored, and no empty (all zero) blocks are
     *  returned.
     *
     *  <pre>
     * set| 0 1
     *   0| 1 1
     *   1| 1 1 <pre>
     */
    protected static class SetStrategy extends AbstractStrategy
    {
        @Override
        //  SetStrategy
        protected int properties()
        {
            return 0;
        }

        @Override
        //  SetStrategy
        protected boolean start(SparseBitSet b)
        {
            return true;
        }

        @Override
        //  SetStrategy
        protected boolean word(int base, int u3, long[] a3, long[] b3, long mask)
        {
            a3[u3] |= mask;
            return false;
        }

        @Override
        //  SetStrategy
        protected boolean block(int base, int u3, int v3, long[] a3, long[] b3)
        {
            for (int w3 = u3; w3 != v3; ++w3)
                a3[w3] = ~0L;
            return false; // set always sets bits
        }
    }

    //-----------------------------------------------------------------------------
    /**
     *  Update the seven statistics that are computed for each set. These are
     *  updated by calling <i>statisticsUpdate</i>, which uses this strategy.
     *
     *  <pre>
     *  update| 0 1
     *       0| 0 0
     *       1| 1 1 <pre>
     *
     * @see SparseBitSet#statisticsUpdate()
     */
    protected class UpdateStrategy extends AbstractStrategy
    {
        /**
         *  Working space for find the size and length of the bit set. Holds the
         *  index of the first non-empty word in the set.
         */
        protected transient int wMin;

        /**
         *  Working space for find the size and length of the bit set. Holds copy of
         *  the first non-empty word in the set.
         */
        protected transient long wordMin;

        /**
         *  Working space for find the size and length of the bit set. Holds the
         *  index of the last non-empty word in the set.
         */
        protected transient int wMax;

        /**
         *  Working space for find the size and length of the bit set. Holds a copy
         *  of the last non-empty word in the set.
         */
        protected transient long wordMax;

        /**
         *  Working space for find the hash value of the bit set. Holds the
         *  current state of the computation of the hash value. This value is
         *  ultimately transferred to the Cache object.
         *
         * @see SparseBitSet.Cache
         */
        protected transient long hash;

        /**
         *  Working space for keeping count of the number of non-zero words in the
         *  bit set. Holds the current state of the computation of the count. This
         *  value is ultimately transferred to the Cache object.
         *
         * @see SparseBitSet.Cache
         */
        protected transient int count;

        /**
         *  Working space for counting the number of non-zero bits in the bit set.
         *  Holds the current state of the computation of the cardinality.This
         *  value is ultimately transferred to the Cache object.
         *
         * @see SparseBitSet.Cache
         */
        protected transient int cardinality;

        @Override
        //  UpdateStrategy
        protected int properties()
        {
            return F_OP_F_EQ_F + F_OP_X_EQ_F;
        }

        /**
         *  This method initializes the computations by suitably resetting cache
         *  fields or working fields.
         *
         * @param       b the other SparseBitSet, for checking if needed.
         *
         * @since       1.6
         */
        @Override
        protected boolean start(SparseBitSet b)
        {
            hash = 1234L; // Magic number
            wMin = -1; // index of first non-zero word
            wordMin = 0L; // word at that index
            wMax = 0; // index of last non-zero word
            wordMax = 0L; // word at that index
            count = 0; // count of non-zero words in whole set
            cardinality = 0; // count of non-zero bits in the whole set
            return false;
        }

        @Override
        protected boolean word(int base, int u3, long[] a3, long[] b3, long mask)
        {
            final long word = a3[u3];
            final long word1 = word & mask;
            if (word1 != 0L)
                compute(base + u3, word1);
            return word == 0L;
        }

        @Override
        //  UpdateStrategy
        protected boolean block(int base, int u3, int v3, long[] a3, long[] b3)
        {
            boolean isZero = true; //  Presumption
            for (int w3 = 0; w3 != v3; ++w3)
            {
                final long word = a3[w3];
                if (word != 0)
                {
                    isZero = false;
                    compute(base + w3, word);
                }
            }
            return isZero;
        }

        @Override
        //  UpdateStrategy
        protected void finish(int a2Count, int a3Count)
        {
            cache.a2Count = a2Count;
            cache.a3Count = a3Count;
            cache.count = count;
            cache.cardinality = cardinality;
            cache.length = (wMax + 1) * LENGTH4 - Long.numberOfLeadingZeros(wordMax);
            cache.size = cache.length - wMin * LENGTH4
                    - Long.numberOfTrailingZeros(wordMin);
            cache.hash = (int) ((hash >> Integer.SIZE) ^ hash);
        }

        /**
         *  This method does the accumulation of the statistics. It must be called
         *  in sequential order of the words in the set for which the statistics
         *  are being accumulated, and only for non-null values of the second
         *  parameter.
         *
         *  Two of the values (a2Count and a3Count) are not updated here,
         *  but are done in the code near where this method is called.
         *
         * @param       index the word index of the word supplied
         * @param       word the long non-zero word from the set
         * @since       1.6
         */
        private void compute(final int index, final long word)
        {
            /*  Count the number of actual words being used. */
            ++count;
            /*  Continue to accumulate the hash value of the set. */
            hash ^= word * (long) (index + 1);
            /*  The first non-zero word contains the first actual bit of the
                set. The location of this bit is used to compute the set size. */
            if (wMin < 0)
            {
                wMin = index;
                wordMin = word;
            }
            /*  The last non-zero word contains the last actual bit of the set.
                The location of this bit is used to compute the set length. */
            wMax = index;
            wordMax = word;
            /*  Count the actual bits, so as to get the cardinality of the set. */
            cardinality += Long.bitCount(word);
        }
    }

    //-----------------------------------------------------------------------------
    /**
     *  The XOR of level3 blocks is computed.
     *
     * <pre>
     * xor| 0 1
     *   0| 0 1
     *   1| 1 0 <pre>
     */
    protected static class XorStrategy extends AbstractStrategy
    {
        @Override
        //  XorStrategy
        protected int properties()
        {
            return F_OP_F_EQ_F + X_OP_F_EQ_X;
        }

        @Override
        //  XorStrategy
        protected boolean start(SparseBitSet b)
        {
            if (b == null)
                throw new NullPointerException();
            return true;
        }

        @Override
        protected boolean word(int base, int u3, long[] a3, long[] b3, long mask)
        {
            return (a3[u3] ^= b3[u3] & mask) == 0;
        }

        @Override
        //  XorStrategy
        protected boolean block(int base, int u3, int v3, long[] a3, long[] b3)
        {
            boolean isZero = true; //  Presumption
            for (int w3 = u3; w3 != v3; ++w3)
                isZero &= (a3[w3] ^= b3[w3]) == 0;
            return isZero;

        }
    }

    //-----------------------------------------------------------------------------
    /**
     *  Word and block <b>and</b> strategy.
     */
    protected static final transient AndStrategy andStrategy = new AndStrategy();
    /**
     *  Word and block <b>andNot</b> strategy.
     */
    protected static final transient AndNotStrategy andNotStrategy = new AndNotStrategy();
    /**
     *  Word and block <b>clear</b> strategy.
     */
    protected static final transient ClearStrategy clearStrategy = new ClearStrategy();
    /**
     *  Word and block <b>copy</b> strategy.
     */
    protected static final transient CopyStrategy copyStrategy = new CopyStrategy();
    /**
     *  Word and block <b>equals</b> strategy.
     */
    protected transient EqualsStrategy equalsStrategy;
    /**
     *  Word and block <b>flip</b> strategy.
     */
    protected static final transient FlipStrategy flipStrategy = new FlipStrategy();
    /**
     *  Word and block <b>intersects</b> strategy.
     */
    protected static transient IntersectsStrategy intersectsStrategy = new IntersectsStrategy();
    /**
     *  Word and block <b>or</b> strategy.
     */
    protected static final transient OrStrategy orStrategy = new OrStrategy();
    /**
     *  Word and block <b>set</b> strategy.
     */
    protected static final transient SetStrategy setStrategy = new SetStrategy();
    /**
     *  Word and block <b>update</b> strategy.
     */
    protected transient UpdateStrategy updateStrategy;
    /**
     *  Word and block <b>xor</b> strategy.
     */
    protected static final transient XorStrategy xorStrategy = new XorStrategy();
}
