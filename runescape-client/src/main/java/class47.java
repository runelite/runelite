import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class47 extends CacheableNode {
   @ObfuscatedName("f")
   public boolean field1065 = false;
   @ObfuscatedName("q")
   public static NodeCache field1066 = new NodeCache(64);
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 650823935
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("k")
   public static class170 field1071;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-435650365"
   )
   public static boolean method976() {
      try {
         if(class186.field3007 == 2) {
            if(class218.field3209 == null) {
               class218.field3209 = class183.method3554(class133.field2114, NPC.field794, class116.field2023);
               if(class218.field3209 == null) {
                  return false;
               }
            }

            if(class117.field2031 == null) {
               class117.field2031 = new class62(class186.field3009, class186.field3005);
            }

            if(class186.field3008.method3641(class218.field3209, class186.field3012, class117.field2031, 22050)) {
               class186.field3008.method3642();
               class186.field3008.method3639(class28.field666);
               class186.field3008.method3702(class218.field3209, class93.field1626);
               class186.field3007 = 0;
               class218.field3209 = null;
               class117.field2031 = null;
               class133.field2114 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class186.field3008.method3735();
         class186.field3007 = 0;
         class218.field3209 = null;
         class117.field2031 = null;
         class133.field2114 = null;
      }

      return false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "22"
   )
   void method977(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1065 = true;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-442309172"
   )
   public void method978(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method977(var1, var2);
      }
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "([LWidget;IB)V",
      garbageValue = "20"
   )
   static final void method982(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3) {
            if(var3.type == 0) {
               if(null != var3.children) {
                  method982(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3828((long)var3.id);
               if(null != var4) {
                  class158.method3191(var4.id, var1);
               }
            }

            class0 var5;
            if(var1 == 0 && null != var3.field2905) {
               var5 = new class0();
               var5.field11 = var3;
               var5.field0 = var3.field2905;
               SecondaryBufferProvider.method1661(var5);
            }

            if(var1 == 1 && null != var3.field2929) {
               if(var3.index >= 0) {
                  Widget var6 = class144.method3012(var3.id);
                  if(null == var6 || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field11 = var3;
               var5.field0 = var3.field2929;
               SecondaryBufferProvider.method1661(var5);
            }
         }
      }

   }
}
