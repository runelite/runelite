import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("n")
   static int[] field1816;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1706957749
   )
   int field1817;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -78291835
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("z")
   int[][] field1819;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1597309099
   )
   int field1820;
   @ObfuscatedName("j")
   int[] field1821;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "867189931"
   )
   static void method2346(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3830((long)var0);
      if(null != var1) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)Lclass227;",
      garbageValue = "-342130449"
   )
   public static class227 method2347(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         class227 var1 = new class227(var0, class79.field1421, class79.field1423, class20.field567, class79.field1424, class79.field1425, class13.field191);
         Friend.method193();
         return var1;
      }
   }

   FrameMap(int var1, byte[] var2) {
      this.field1820 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1817 = var3.method2556();
      this.field1821 = new int[this.field1817];
      this.field1819 = new int[this.field1817][];

      int var4;
      for(var4 = 0; var4 < this.field1817; ++var4) {
         this.field1821[var4] = var3.method2556();
      }

      for(var4 = 0; var4 < this.field1817; ++var4) {
         this.field1819[var4] = new int[var3.method2556()];
      }

      for(var4 = 0; var4 < this.field1817; ++var4) {
         for(int var5 = 0; var5 < this.field1819[var4].length; ++var5) {
            this.field1819[var4][var5] = var3.method2556();
         }
      }

   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2146169811"
   )
   static final void method2348() {
      Client.field323.method2818(127);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3821(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3822()) {
         if(var0.field53 == 0 || var0.field53 == 3) {
            class62.method1313(var0, true);
         }
      }

      if(null != Client.field443) {
         class75.method1606(Client.field443);
         Client.field443 = null;
      }

   }
}
