import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("j")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("x")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("s")
   public static class170 field869;
   @ObfuscatedName("t")
   public static NodeCache field870 = new NodeCache(64);
   @ObfuscatedName("g")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("ge")
   static Widget field873;
   @ObfuscatedName("ab")
   public boolean field874 = false;
   @ObfuscatedName("k")
   int[] field875;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -354028025
   )
   public int field876 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1062270891
   )
   public int field877 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -119725445
   )
   public int field878 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -867531847
   )
   public int field879 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 104975659
   )
   @Export("id")
   public int id;
   @ObfuscatedName("f")
   @Export("models")
   int[] models;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1641335913
   )
   public int field882 = -1;
   @ObfuscatedName("b")
   short[] field883;
   @ObfuscatedName("q")
   short[] field884;
   @ObfuscatedName("o")
   short[] field885;
   @ObfuscatedName("c")
   short[] field886;
   @ObfuscatedName("z")
   public static class170 field887;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1624583029
   )
   public int field888 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1997542651
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -142635921
   )
   int field890 = 128;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2097651897
   )
   int field891 = 128;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 722128749
   )
   int field892 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 2131090905
   )
   int field893 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 59160765
   )
   int field894 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1290268095
   )
   public int field895 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1422979685
   )
   public int field896 = 32;
   @ObfuscatedName("ax")
   public int[] field897;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 381405241
   )
   int field898 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 655812661
   )
   public int field899 = -1;
   @ObfuscatedName("an")
   public boolean field900 = true;
   @ObfuscatedName("ag")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1638635355
   )
   public int field902 = 1;
   @ObfuscatedName("y")
   @Export("npcModelCache")
   public static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("i")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("ec")
   static SpritePixels[] field907;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "1"
   )
   public final ModelData method784() {
      if(null != this.field897) {
         NPCComposition var1 = this.method790();
         return null == var1?null:var1.method784();
      } else if(this.field875 == null) {
         return null;
      } else {
         boolean var6 = false;

         for(int var2 = 0; var2 < this.field875.length; ++var2) {
            if(!field887.method3252(this.field875[var2], 0)) {
               var6 = true;
            }
         }

         if(var6) {
            return null;
         } else {
            ModelData[] var5 = new ModelData[this.field875.length];

            for(int var3 = 0; var3 < this.field875.length; ++var3) {
               var5[var3] = ModelData.method2184(field887, this.field875[var3], 0);
            }

            ModelData var7;
            if(var5.length == 1) {
               var7 = var5[0];
            } else {
               var7 = new ModelData(var5, var5.length);
            }

            int var4;
            if(this.field883 != null) {
               for(var4 = 0; var4 < this.field883.length; ++var4) {
                  var7.method2197(this.field883[var4], this.field884[var4]);
               }
            }

            if(null != this.field885) {
               for(var4 = 0; var4 < this.field885.length; ++var4) {
                  var7.method2234(this.field885[var4], this.field886[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-18"
   )
   void method786(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method787(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "51"
   )
   void method787(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2481();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.method2668();
         }
      } else if(var2 == 2) {
         this.name = var1.method2503();
      } else if(var2 == 12) {
         this.field902 = var1.method2481();
      } else if(var2 == 13) {
         this.field876 = var1.method2668();
      } else if(var2 == 14) {
         this.field899 = var1.method2668();
      } else if(var2 == 15) {
         this.field877 = var1.method2668();
      } else if(var2 == 16) {
         this.field878 = var1.method2668();
      } else if(var2 == 17) {
         this.field899 = var1.method2668();
         this.field879 = var1.method2668();
         this.field888 = var1.method2668();
         this.field882 = var1.method2668();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2503();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2481();
         this.field883 = new short[var3];
         this.field884 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field883[var4] = (short)var1.method2668();
            this.field884[var4] = (short)var1.method2668();
         }
      } else if(var2 == 41) {
         var3 = var1.method2481();
         this.field885 = new short[var3];
         this.field886 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field885[var4] = (short)var1.method2668();
            this.field886[var4] = (short)var1.method2668();
         }
      } else if(var2 == 60) {
         var3 = var1.method2481();
         this.field875 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field875[var4] = var1.method2668();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.method2668();
      } else if(var2 == 97) {
         this.field890 = var1.method2668();
      } else if(var2 == 98) {
         this.field891 = var1.method2668();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field893 = var1.method2601();
      } else if(var2 == 101) {
         this.field894 = var1.method2601() * 5;
      } else if(var2 == 102) {
         this.field895 = var1.method2668();
      } else if(var2 == 103) {
         this.field896 = var1.method2668();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field900 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field874 = true;
         }
      } else {
         this.field898 = var1.method2668();
         if(this.field898 == '\uffff') {
            this.field898 = -1;
         }

         this.field892 = var1.method2668();
         if(this.field892 == '\uffff') {
            this.field892 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.method2668();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.method2481();
         this.field897 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field897[var5] = var1.method2668();
            if(this.field897[var5] == '\uffff') {
               this.field897[var5] = -1;
            }
         }

         this.field897[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "1655093923"
   )
   public final Model method788(Sequence var1, int var2, Sequence var3, int var4) {
      if(null != this.field897) {
         NPCComposition var12 = this.method790();
         return var12 == null?null:var12.method788(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var6 = false;

            for(int var10 = 0; var10 < this.models.length; ++var10) {
               if(!field887.method3252(this.models[var10], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2184(field887, this.models[var9], 0);
            }

            ModelData var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new ModelData(var8, var8.length);
            }

            if(null != this.field883) {
               for(var9 = 0; var9 < this.field883.length; ++var9) {
                  var7.method2197(this.field883[var9], this.field884[var9]);
               }
            }

            if(null != this.field885) {
               for(var9 = 0; var9 < this.field885.length; ++var9) {
                  var7.method2234(this.field885[var9], this.field886[var9]);
               }
            }

            var5 = var7.method2203(64 + this.field893, this.field894 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var11;
         if(null != var1 && null != var3) {
            var11 = var1.method884(var5, var2, var3, var4);
         } else if(var1 != null) {
            var11 = var1.method908(var5, var2);
         } else if(var3 != null) {
            var11 = var3.method908(var5, var4);
         } else {
            var11 = var5.method2272(true);
         }

         if(this.field890 != 128 || this.field891 != 128) {
            var11.method2333(this.field890, this.field891, this.field890);
         }

         return var11;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)LNPCComposition;",
      garbageValue = "2"
   )
   public final NPCComposition method790() {
      int var1 = -1;
      if(this.field898 != -1) {
         var1 = class173.method3381(this.field898);
      } else if(this.field892 != -1) {
         var1 = class179.widgetSettings[this.field892];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field897.length - 1) {
         var2 = this.field897[var1];
      } else {
         var2 = this.field897[this.field897.length - 1];
      }

      return var2 != -1?class127.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1913434566"
   )
   void method792() {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2046345336"
   )
   public boolean method801() {
      if(null == this.field897) {
         return true;
      } else {
         int var1 = -1;
         if(this.field898 != -1) {
            var1 = class173.method3381(this.field898);
         } else if(this.field892 != -1) {
            var1 = class179.widgetSettings[this.field892];
         }

         return var1 >= 0 && var1 < this.field897.length?this.field897[var1] != -1:this.field897[this.field897.length - 1] != -1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2059750055"
   )
   static int method811(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      return SecondaryBufferProvider.field1416 != null && var2 == SecondaryBufferProvider.field1416.hash?1 + class43.field962.offset * 99 / (class43.field962.payload.length - SecondaryBufferProvider.field1416.field2783):0;
   }
}
