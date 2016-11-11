import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class49 extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -124200809
   )
   public int field1079 = 1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -402973145
   )
   public int field1080 = 0;
   @ObfuscatedName("g")
   static NodeCache field1081 = new NodeCache(64);
   @ObfuscatedName("i")
   public static class170 field1082;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2096914455
   )
   public int field1083 = 255;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -708854171
   )
   public int field1084 = 255;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -438292841
   )
   public int field1085 = 30;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1733067375
   )
   public int field1086 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 86886943
   )
   public int field1087 = 70;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2032761409
   )
   int field1088 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 744089845
   )
   int field1089 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1756724915
   )
   public int field1090;
   @ObfuscatedName("e")
   static NodeCache field1091 = new NodeCache(64);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-3"
   )
   void method1001(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method1017(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1966847871"
   )
   public SpritePixels method1003() {
      if(this.field1088 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1081.get((long)this.field1088);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method13(RSCanvas.field2193, this.field1088, 0);
            if(null != var1) {
               field1081.put(var1, (long)this.field1088);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "194483608"
   )
   public SpritePixels method1004() {
      if(this.field1089 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1081.get((long)this.field1089);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method13(RSCanvas.field2193, this.field1089, 0);
            if(var1 != null) {
               field1081.put(var1, (long)this.field1089);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "382985046"
   )
   static final void method1007(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1007(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3812((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(class14.method172(var5)) {
                     method1007(Widget.widgets[var5], var1);
                  }
               }
            }

            class0 var6;
            if(var1 == 0 && null != var3.field2806) {
               var6 = new class0();
               var6.field13 = var3;
               var6.field8 = var3.field2806;
               class12.method155(var6);
            }

            if(var1 == 1 && null != var3.field2849) {
               if(var3.index >= 0) {
                  Widget var7 = class173.method3412(var3.id);
                  if(null == var7 || var7.children == null || var3.index >= var7.children.length || var7.children[var3.index] != var3) {
                     continue;
                  }
               }

               var6 = new class0();
               var6.field13 = var3;
               var6.field8 = var3.field2849;
               class12.method155(var6);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "471888108"
   )
   void method1017(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.method2546();
      } else if(var2 == 2) {
         this.field1083 = var1.method2544();
      } else if(var2 == 3) {
         this.field1084 = var1.method2544();
      } else if(var2 == 4) {
         this.field1086 = 0;
      } else if(var2 == 5) {
         this.field1087 = var1.method2546();
      } else if(var2 == 6) {
         var1.method2544();
      } else if(var2 == 7) {
         this.field1088 = var1.method2617();
      } else if(var2 == 8) {
         this.field1089 = var1.method2617();
      } else if(var2 == 11) {
         this.field1086 = var1.method2546();
      } else if(var2 == 14) {
         this.field1085 = var1.method2544();
      } else if(var2 == 15) {
         this.field1080 = var1.method2544();
      }

   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-6"
   )
   static final void method1020(String var0) {
      if(var0 != null) {
         String var1 = class93.method2141(var0, Client.field302);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = class93.method2141(var4, Client.field302);
               if(Sequence.method920(var0, var1, var4, var5)) {
                  --Client.friendCount;

                  for(int var6 = var2; var6 < Client.friendCount; ++var6) {
                     Client.friends[var6] = Client.friends[1 + var6];
                  }

                  Client.field493 = Client.field485;
                  Client.field378.method2801(188);
                  Client.field378.method2529(class21.method547(var0));
                  Client.field378.method2535(var0);
                  break;
               }
            }

         }
      }
   }
}
