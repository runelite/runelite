import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("ItemLayer")
public final class class98 {
   @ObfuscatedName("y")
   @Export("middle")
   class84 field1669;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1428007657
   )
   @Export("y")
   int field1670;
   @ObfuscatedName("s")
   @Export("bottom")
   class84 field1671;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 360153119
   )
   @Export("height")
   int field1672;
   @ObfuscatedName("e")
   @Export("top")
   class84 field1673;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 713144085
   )
   @Export("flags")
   int field1674;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1979191033
   )
   @Export("hash")
   int field1675;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 683648049
   )
   @Export("x")
   int field1676;

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "900795537"
   )
   static final void method2216(class66 var0) {
      var0.field1263 = false;
      if(var0.field1266 != null) {
         var0.field1266.field1262 = 0;
      }

      for(class66 var1 = var0.vmethod3767(); null != var1; var1 = var0.vmethod3752()) {
         method2216(var1);
      }

   }

   @ObfuscatedName("a")
   public static void method2217(Component var0) {
      var0.addMouseListener(class139.field2136);
      var0.addMouseMotionListener(class139.field2136);
      var0.addFocusListener(class139.field2136);
   }
}
