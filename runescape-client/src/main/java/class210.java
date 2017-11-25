import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class210 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field2596;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field2594;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field2597;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   public static class211 field2595;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -965389261
   )
   public static int field2598;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -410459365
   )
   public static int field2599;

   static {
      field2598 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lid;Ljava/lang/String;Ljava/lang/String;I)[Lkl;",
      garbageValue = "-1212231005"
   )
   public static IndexedSprite[] method3855(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class163.method3187(var0, var3, var4);
   }
}
