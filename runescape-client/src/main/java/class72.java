import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class72 implements Runnable {
   @ObfuscatedName("u")
   volatile class56[] field1364 = new class56[2];
   @ObfuscatedName("x")
   volatile boolean field1365 = false;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 224597987
   )
   static int field1367;
   @ObfuscatedName("b")
   volatile boolean field1369 = false;
   @ObfuscatedName("f")
   class136 field1370;

   public void run() {
      this.field1369 = true;

      try {
         while(!this.field1365) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class56 var2 = this.field1364[var1];
               if(null != var2) {
                  var2.method1251();
               }
            }

            class98.method2264(10L);
            class164.method3257(this.field1370, (Object)null);
         }
      } catch (Exception var7) {
         class45.method984((String)null, var7);
      } finally {
         this.field1369 = false;
      }

   }

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-8188704"
   )
   static void method1636(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class3.field73; ++var4) {
         class51 var5 = class141.method3001(var4);
         if((!var1 || var5.field1160) && var5.field1153 == -1 && var5.field1128.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class24.field625 = -1;
               class106.field1874 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[2 * var2.length];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class106.field1874 = var2;
      class163.field2647 = 0;
      class24.field625 = var3;
      String[] var8 = new String[class24.field625];

      for(int var9 = 0; var9 < class24.field625; ++var9) {
         var8[var9] = class141.method3001(var2[var9]).field1128;
      }

      class16.method192(var8, class106.field1874);
   }
}
