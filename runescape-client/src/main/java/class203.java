import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class203 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1041905405
   )
   public static int field2501;
   @ObfuscatedName("s")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("r")
   public static class204 field2500;
   @ObfuscatedName("g")
   public static class112 field2506;
   @ObfuscatedName("e")
   public static IndexDataBase field2502;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1129866053
   )
   public static int field2503;
   @ObfuscatedName("n")
   public static IndexDataBase field2499;
   @ObfuscatedName("j")
   public static IndexDataBase field2512;
   @ObfuscatedName("a")
   public static IndexDataBase field2498;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1824767665
   )
   public static int field2504;
   @ObfuscatedName("m")
   public static boolean field2505;
   @ObfuscatedName("ps")
   static class102 field2511;
   @ObfuscatedName("lj")
   static Widget[] field2508;
   @ObfuscatedName("gl")
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("cv")
   public static char field2510;

   static {
      field2501 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IB)Lclass207;",
      garbageValue = "-30"
   )
   static class207 method3695(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4088(var1);
      return var2 == null?null:new class207(var2);
   }
}
