import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class97 implements class158 {
   @ObfuscatedName("n")
   public static final class97 field1635 = new class97(0, 1);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2005609585
   )
   final int field1636;
   @ObfuscatedName("g")
   public static final class97 field1637 = new class97(2, 2);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 463662021
   )
   public final int field1638;
   @ObfuscatedName("x")
   public static final class97 field1639 = new class97(1, 0);
   @ObfuscatedName("v")
   public static final class97 field1641 = new class97(3, 3);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-112"
   )
   public int vmethod4107() {
      return this.field1636;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1638 = var1;
      this.field1636 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1233261949"
   )
   public static void method2025(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "-1718904917"
   )
   static void method2026(byte[] var0, int var1) {
      if(Client.field326 == null) {
         Client.field326 = new byte[24];
      }

      class163.method3215(var0, var1, Client.field326, 0, 24);
   }

   @ObfuscatedName("x")
   public static String method2027(long var0) {
      class162.field2148.setTime(new Date(var0));
      int var2 = class162.field2148.get(7);
      int var3 = class162.field2148.get(5);
      int var4 = class162.field2148.get(2);
      int var5 = class162.field2148.get(1);
      int var6 = class162.field2148.get(11);
      int var7 = class162.field2148.get(12);
      int var8 = class162.field2148.get(13);
      return class162.field2147[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class162.field2153[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-325265000"
   )
   static final void method2028(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method2028(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2437((long)var3.id);
               if(var4 != null) {
                  class104.method2090(var4.id, var1);
               }
            }

            class18 var5;
            if(var1 == 0 && null != var3.field2313) {
               var5 = new class18();
               var5.field188 = var3;
               var5.field196 = var3.field2313;
               class40.method828(var5);
            }

            if(var1 == 1 && null != var3.field2314) {
               if(var3.index >= 0) {
                  Widget var6 = ChatLineBuffer.method993(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new class18();
               var5.field188 = var3;
               var5.field196 = var3.field2314;
               class40.method828(var5);
            }
         }
      }

   }
}
