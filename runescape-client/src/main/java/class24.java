import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("XClanMember")
public class class24 extends class208 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -193503505
   )
   @Export("world")
   int field622;
   @ObfuscatedName("b")
   @Export("rank")
   byte field623;
   @ObfuscatedName("u")
   String field624;
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = -1268427989
   )
   static int field625;
   @ObfuscatedName("f")
   @Export("username")
   String field629;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "1525806644"
   )
   static void method632(int var0, boolean var1, int var2, boolean var3) {
      if(class25.field635 != null) {
         class50.method1071(0, class25.field635.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "976465964"
   )
   static final void method633(int var0) {
      if(class135.method2897(var0)) {
         class99.method2269(class173.field2770[var0], -1);
      }
   }
}
