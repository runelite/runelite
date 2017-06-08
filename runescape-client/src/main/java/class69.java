import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class69 extends Node {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1829463723
   )
   int field822;
   @ObfuscatedName("p")
   boolean field823;
   @ObfuscatedName("i")
   Widget field824;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1678525837
   )
   int field826;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 259733619
   )
   int field827;
   @ObfuscatedName("g")
   String field828;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1602397611
   )
   int field829;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1960853293
   )
   int field830;
   @ObfuscatedName("o")
   class219 field831;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1511355601
   )
   int field832;
   @ObfuscatedName("n")
   Object[] field833;
   @ObfuscatedName("ri")
   static class13 field834;
   @ObfuscatedName("c")
   Widget field835;
   @ObfuscatedName("bc")
   static ModIcon field836;
   @ObfuscatedName("ci")
   @Export("indexInterfaces")
   static IndexData indexInterfaces;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lclass103;B)V",
      garbageValue = "0"
   )
   public static final void method1069(class103 var0) {
      class109.field1635 = var0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;B)V",
      garbageValue = "-63"
   )
   public void method1070(Object[] var1) {
      this.field833 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass219;I)V",
      garbageValue = "105996265"
   )
   public void method1071(class219 var1) {
      this.field831 = var1;
   }

   public class69() {
      this.field831 = class219.field2788;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "8842"
   )
   static String method1076() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class98.field1524.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1499716047"
   )
   static final void method1078(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1119; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field1121[var4] = true;
         }
      }

   }
}
