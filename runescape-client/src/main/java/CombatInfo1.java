import java.awt.Component;
import java.awt.event.ActionEvent;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("z")
   public static boolean field665;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1799972201
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -74485247
   )
   int field667;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1399651075
   )
   int field668;
   @ObfuscatedName("go")
   static Widget field669;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1930750747
   )
   int field673;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field667 = var1;
      this.healthRatio = var2;
      this.field673 = var3;
      this.field668 = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-299705579"
   )
   void method591(int var1, int var2, int var3, int var4) {
      this.field667 = var1;
      this.healthRatio = var2;
      this.field673 = var3;
      this.field668 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-117"
   )
   public static int method592(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "496"
   )
   public static void method593(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class105.keyboard);
      var0.addFocusListener(class105.keyboard);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/lang/Object;B)V",
      garbageValue = "95"
   )
   public static void method594(class103 var0, Object var1) {
      if(var0.field1669 != null) {
         for(int var2 = 0; var2 < 50 && var0.field1669.peekEvent() != null; ++var2) {
            XClanMember.method237(1L);
         }

         if(null != var1) {
            var0.field1669.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }
}
