import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class134 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1054720061
   )
   public static int field2001;
   @ObfuscatedName("y")
   public static int[] field2002;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -223375821
   )
   public static int field2003;
   @ObfuscatedName("j")
   public static boolean field2004;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 690923339
   )
   static int field2005;
   @ObfuscatedName("n")
   public static boolean field2007;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -818666273
   )
   static int field2008;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 278535761
   )
   public static int field2009;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 66733645
   )
   static int field2010;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2146727275
   )
   static int field2011;

   static {
      field2007 = false;
      field2001 = 0;
      field2003 = 0;
      field2004 = false;
      field2009 = 0;
      field2002 = new int[1000];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-526653472"
   )
   public static synchronized long method2587() {
      long var0 = System.currentTimeMillis();
      if(var0 < class175.field2414) {
         class175.field2416 += class175.field2414 - var0;
      }

      class175.field2414 = var0;
      return class175.field2416 + var0;
   }
}
