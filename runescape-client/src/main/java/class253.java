import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class253 extends CacheableNode {
   @ObfuscatedName("b")
   public String field3396;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1243068017
   )
   public int field3397;
   @ObfuscatedName("e")
   public char field3398;
   @ObfuscatedName("c")
   static NodeCache field3399;
   @ObfuscatedName("v")
   public char field3400;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -49014589
   )
   public int field3401;
   @ObfuscatedName("i")
   public static IndexDataBase field3402;
   @ObfuscatedName("x")
   public int[] field3403;
   @ObfuscatedName("f")
   public int[] field3404;
   @ObfuscatedName("n")
   public String[] field3405;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2140680469"
   )
   void method4471(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3398 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field3400 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3396 = var1.readString();
      } else if(var2 == 4) {
         this.field3401 = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.field3397 = var1.readUnsignedShort();
            this.field3403 = new int[this.field3397];
            this.field3405 = new String[this.field3397];

            for(var3 = 0; var3 < this.field3397; ++var3) {
               this.field3403[var3] = var1.readInt();
               this.field3405[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.field3397 = var1.readUnsignedShort();
            this.field3403 = new int[this.field3397];
            this.field3404 = new int[this.field3397];

            for(var3 = 0; var3 < this.field3397; ++var3) {
               this.field3403[var3] = var1.readInt();
               this.field3404[var3] = var1.readInt();
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "0"
   )
   void method4472(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4471(var1, var2);
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "982994135"
   )
   static final void method4473(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class89.method1700(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && class89.method1700(var3) && var3 != WorldMapType1.field434) {
                  continue;
               }

               method4473(var0, var3.id);
               if(var3.children != null) {
                  method4473(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3520((long)var3.id);
               if(var4 != null) {
                  FaceNormal.method2867(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2698 != -1 || var3.field2699 != -1) {
                  boolean var7 = class137.method2672(var3);
                  if(var7) {
                     var5 = var3.field2699;
                  } else {
                     var5 = var3.field2698;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class227.getAnimation(var5);

                     for(var3.field2774 += Client.field1119; var3.field2774 > var6.frameLenghts[var3.field2675]; class25.method169(var3)) {
                        var3.field2774 -= var6.frameLenghts[var3.field2675];
                        ++var3.field2675;
                        if(var3.field2675 >= var6.frameIDs.length) {
                           var3.field2675 -= var6.frameStep;
                           if(var3.field2675 < 0 || var3.field2675 >= var6.frameIDs.length) {
                              var3.field2675 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2707 != 0 && !var3.hasScript) {
                  int var8 = var3.field2707 >> 16;
                  var5 = var3.field2707 << 16 >> 16;
                  var8 *= Client.field1119;
                  var5 *= Client.field1119;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var3.rotationZ + var5 & 2047;
                  class25.method169(var3);
               }
            }
         }
      }

   }

   static {
      field3399 = new NodeCache(64);
   }

   class253() {
      this.field3396 = "null";
      this.field3397 = 0;
   }
}
