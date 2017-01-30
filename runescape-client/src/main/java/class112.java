import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public abstract class class112 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-278207780"
   )
   public abstract void vmethod2084(Component var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-963485446"
   )
   public abstract int vmethod2087();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1898772610"
   )
   public abstract void vmethod2092(Component var1);

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "967977968"
   )
   static final void method2096(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field360) {
         Client.field487 = 32;
      } else {
         Client.field487 = 0;
      }

      Client.field360 = false;
      int var7;
      if(class115.field1804 == 1 || !class48.field937 && class115.field1804 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < 16 + var2) {
            var0.scrollY -= 4;
            class33.method682(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.scrollY += 4;
            class33.method682(var0);
         } else if(var5 >= var1 - Client.field487 && var5 < Client.field487 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class33.method682(var0);
            Client.field360 = true;
         }
      }

      if(Client.field475 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.field475 * 45;
            class33.method682(var0);
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "105735313"
   )
   public static void method2097() {
      try {
         class104.field1688.method1368();

         for(int var0 = 0; var0 < class104.field1681; ++var0) {
            Friend.field151[var0].method1368();
         }

         class104.field1689.method1368();
         class104.field1683.method1368();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)LMessageNode;",
      garbageValue = "36"
   )
   static MessageNode method2098(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return var2.method885(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZI)I",
      garbageValue = "14289622"
   )
   static int method2099(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class109.method2040(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class109.method2040(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1970896981"
   )
   public static int method2100(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + ItemLayer.method1457(var0.charAt(var3));
      }

      return var2;
   }
}
