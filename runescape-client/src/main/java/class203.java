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
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static class204 field2500;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   public static class112 field2506;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field2502;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1129866053
   )
   public static int field2503;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field2499;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field2512;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field2498;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1824767665
   )
   public static int field2504;
   @ObfuscatedName("m")
   public static boolean field2505;
   @ObfuscatedName("ps")
   @ObfuscatedSignature(
      signature = "Lce;"
   )
   static class102 field2511;
   @ObfuscatedName("lj")
   @ObfuscatedSignature(
      signature = "[Lhy;"
   )
   static Widget[] field2508;
   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("cv")
   public static char field2510;

   static {
      field2501 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lif;IB)Lgu;",
      garbageValue = "-30"
   )
   static class207 method3695(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4088(var1);
      return var2 == null?null:new class207(var2);
   }
}
