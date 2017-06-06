import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("b")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1243068017
   )
   @Export("size")
   public int size;
   @ObfuscatedName("e")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("c")
   static NodeCache field3399;
   @ObfuscatedName("v")
   @Export("valType")
   public char valType;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -49014589
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("i")
   public static IndexDataBase field3402;
   @ObfuscatedName("x")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("f")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("n")
   @Export("stringVals")
   public String[] stringVals;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2140680469"
   )
   void method4471(Buffer var1, int var2) {
      if(var2 == 1) {
         this.keyType = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.valType = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.defaultString = var1.readString();
      } else if(var2 == 4) {
         this.defaultInt = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.size = var1.readUnsignedShort();
            this.keys = new int[this.size];
            this.stringVals = new String[this.size];

            for(var3 = 0; var3 < this.size; ++var3) {
               this.keys[var3] = var1.readInt();
               this.stringVals[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.size = var1.readUnsignedShort();
            this.keys = new int[this.size];
            this.intVals = new int[this.size];

            for(var3 = 0; var3 < this.size; ++var3) {
               this.keys[var3] = var1.readInt();
               this.intVals[var3] = var1.readInt();
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

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }
}
