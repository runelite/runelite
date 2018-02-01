import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public enum class250 implements MouseWheel {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   field3338(0, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   field3339(1, 1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   field3340(2, 2);

   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1264013871
   )
   public final int field3341;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 101167691
   )
   final int field3342;

   class250(int var3, int var4) {
      this.field3341 = var3;
      this.field3342 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int rsOrdinal() {
      return this.field3342;
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "([Lho;IB)V",
      garbageValue = "-116"
   )
   static final void method4527(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !WorldMapType3.method220(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && WorldMapType3.method220(var3) && var3 != FileRequest.field3287) {
                  continue;
               }

               method4527(var0, var3.id);
               if(var3.children != null) {
                  method4527(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  var5 = var4.id;
                  if(class213.loadWidget(var5)) {
                     method4527(FileRequest.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2785 != -1 || var3.field2786 != -1) {
                  boolean var7 = class19.method161(var3);
                  if(var7) {
                     var5 = var3.field2786;
                  } else {
                     var5 = var3.field2785;
                  }

                  if(var5 != -1) {
                     Sequence var6 = CacheFile.getAnimation(var5);

                     for(var3.field2871 += Client.field882; var3.field2871 > var6.frameLenghts[var3.field2860]; class60.method1015(var3)) {
                        var3.field2871 -= var6.frameLenghts[var3.field2860];
                        ++var3.field2860;
                        if(var3.field2860 >= var6.frameIDs.length) {
                           var3.field2860 -= var6.frameStep;
                           if(var3.field2860 < 0 || var3.field2860 >= var6.frameIDs.length) {
                              var3.field2860 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2794 != 0 && !var3.hasScript) {
                  int var8 = var3.field2794 >> 16;
                  var5 = var3.field2794 << 16 >> 16;
                  var8 *= Client.field882;
                  var5 *= Client.field882;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class60.method1015(var3);
               }
            }
         }
      }

   }
}
