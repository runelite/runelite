import java.awt.Component;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class50 extends class204 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1336394915
   )
   public int field1109 = 0;
   @ObfuscatedName("u")
   public static class193 field1110 = new class193(64);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "1"
   )
   public static void method1063(Component var0) {
      var0.removeKeyListener(class137.field2118);
      var0.removeFocusListener(class137.field2118);
      class137.field2113 = -1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "2094287608"
   )
   public void method1064(class119 var1) {
      while(true) {
         int var2 = var1.method2554();
         if(var2 == 0) {
            return;
         }

         this.method1065(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-19572944"
   )
   void method1065(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1109 = var1.method2556();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1139099350"
   )
   static void method1071(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         class25 var8 = class25.field635[var6];
         class25.field635[var6] = class25.field635[var1];
         class25.field635[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class20.method598(class25.field635[var9], var8, var2, var3, var4, var5) <= 0) {
               class25 var10 = class25.field635[var9];
               class25.field635[var9] = class25.field635[var7];
               class25.field635[var7++] = var10;
            }
         }

         class25.field635[var1] = class25.field635[var7];
         class25.field635[var7] = var8;
         method1071(var0, var7 - 1, var2, var3, var4, var5);
         method1071(1 + var7, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass168;IIIBZI)V",
      garbageValue = "-1418413272"
   )
   static void method1072(class168 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class172 var8 = (class172)class171.field2713.method3822(var6);
      if(var8 == null) {
         var8 = (class172)class171.field2715.method3822(var6);
         if(null == var8) {
            var8 = (class172)class171.field2718.method3822(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3922();
                  class171.field2713.method3826(var8, var6);
                  --class171.field2719;
                  ++class171.field2730;
               }

            } else {
               if(!var5) {
                  var8 = (class172)class171.field2720.method3822(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class172();
               var8.field2741 = var0;
               var8.field2735 = var3;
               var8.field2737 = var4;
               if(var5) {
                  class171.field2713.method3826(var8, var6);
                  ++class171.field2730;
               } else {
                  class171.field2717.method3908(var8);
                  class171.field2718.method3826(var8, var6);
                  ++class171.field2719;
               }

            }
         }
      }
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1696658474"
   )
   static final void method1074(boolean var0) {
      class8.method114();
      ++client.field339;
      if(client.field339 >= 50 || var0) {
         client.field339 = 0;
         if(!client.field361 && class172.field2742 != null) {
            client.field333.method2773(144);

            try {
               class172.field2742.method3018(client.field333.field2000, 0, client.field333.field1998);
               client.field333.field1998 = 0;
            } catch (IOException var2) {
               client.field361 = true;
            }
         }

      }
   }
}
