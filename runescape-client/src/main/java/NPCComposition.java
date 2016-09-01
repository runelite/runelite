import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("p")
   int[] field884;
   @ObfuscatedName("r")
   public static class170 field885;
   @ObfuscatedName("j")
   public static NodeCache field886 = new NodeCache(64);
   @ObfuscatedName("af")
   public boolean field887 = false;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -977212931
   )
   @Export("id")
   public int id;
   @ObfuscatedName("b")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1133863977
   )
   int field890 = 128;
   @ObfuscatedName("m")
   @Export("models")
   int[] models;
   @ObfuscatedName("o")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -44841833
   )
   public int field893 = -1;
   @ObfuscatedName("x")
   public static class170 field894;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1262784569
   )
   public int field895 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1925393079
   )
   public int field896 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1778223673
   )
   int field897 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -403558725
   )
   public int field898 = -1;
   @ObfuscatedName("a")
   short[] field899;
   @ObfuscatedName("h")
   short[] field900;
   @ObfuscatedName("u")
   short[] field901;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1285135081
   )
   public int field902 = 1;
   @ObfuscatedName("e")
   short[] field903;
   @ObfuscatedName("c")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("n")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1633483881
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 963362627
   )
   public int field907 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1159737661
   )
   int field908 = 128;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1317673943
   )
   public int field909 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -299912603
   )
   int field910 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1685908673
   )
   int field911 = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 107397771
   )
   public int field913 = 32;
   @ObfuscatedName("aq")
   public int[] field914;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1207310807
   )
   int field915 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 83138941
   )
   public int field916 = -1;
   @ObfuscatedName("ap")
   public boolean field917 = true;
   @ObfuscatedName("ao")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 199680553
   )
   public int field919 = -1;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1986312711
   )
   static int field920;
   @ObfuscatedName("z")
   @Export("npcModelCache")
   public static NodeCache npcModelCache = new NodeCache(50);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)Z",
      garbageValue = "-872163065"
   )
   public static boolean method775(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3290(var1, var2);
      if(null == var3) {
         return false;
      } else {
         class43.method858(var3);
         return true;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "12570"
   )
   void method776(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2556();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.method2551();
         }
      } else if(var2 == 2) {
         this.name = var1.method2774();
      } else if(var2 == 12) {
         this.field902 = var1.method2556();
      } else if(var2 == 13) {
         this.field893 = var1.method2551();
      } else if(var2 == 14) {
         this.field896 = var1.method2551();
      } else if(var2 == 15) {
         this.field907 = var1.method2551();
      } else if(var2 == 16) {
         this.field919 = var1.method2551();
      } else if(var2 == 17) {
         this.field896 = var1.method2551();
         this.field909 = var1.method2551();
         this.field898 = var1.method2551();
         this.field916 = var1.method2551();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2774();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2556();
         this.field900 = new short[var3];
         this.field901 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field900[var4] = (short)var1.method2551();
            this.field901[var4] = (short)var1.method2551();
         }
      } else if(var2 == 41) {
         var3 = var1.method2556();
         this.field899 = new short[var3];
         this.field903 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field899[var4] = (short)var1.method2551();
            this.field903[var4] = (short)var1.method2551();
         }
      } else if(var2 == 60) {
         var3 = var1.method2556();
         this.field884 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field884[var4] = var1.method2551();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.method2551();
      } else if(var2 == 97) {
         this.field890 = var1.method2551();
      } else if(var2 == 98) {
         this.field908 = var1.method2551();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field910 = var1.method2557();
      } else if(var2 == 101) {
         this.field911 = var1.method2557() * 5;
      } else if(var2 == 102) {
         this.field895 = var1.method2551();
      } else if(var2 == 103) {
         this.field913 = var1.method2551();
      } else if(var2 == 106) {
         this.field915 = var1.method2551();
         if(this.field915 == '\uffff') {
            this.field915 = -1;
         }

         this.field897 = var1.method2551();
         if(this.field897 == '\uffff') {
            this.field897 = -1;
         }

         var3 = var1.method2556();
         this.field914 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field914[var4] = var1.method2551();
            if(this.field914[var4] == '\uffff') {
               this.field914[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field917 = false;
      } else if(var2 == 109) {
         this.isClickable = false;
      } else if(var2 == 111) {
         this.field887 = true;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "6"
   )
   public final Model method777(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field914 != null) {
         NPCComposition var12 = this.method779();
         return null == var12?null:var12.method777(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field885.method3292(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2262(field885, this.models[var9], 0);
            }

            ModelData var10;
            if(var8.length == 1) {
               var10 = var8[0];
            } else {
               var10 = new ModelData(var8, var8.length);
            }

            if(this.field900 != null) {
               for(var9 = 0; var9 < this.field900.length; ++var9) {
                  var10.method2337(this.field900[var9], this.field901[var9]);
               }
            }

            if(null != this.field899) {
               for(var9 = 0; var9 < this.field899.length; ++var9) {
                  var10.method2276(this.field899[var9], this.field903[var9]);
               }
            }

            var5 = var10.method2290(64 + this.field910, 850 + this.field911, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var11;
         if(var1 != null && var3 != null) {
            var11 = var1.method880(var5, var2, var3, var4);
         } else if(var1 != null) {
            var11 = var1.method864(var5, var2);
         } else if(null != var3) {
            var11 = var3.method864(var5, var4);
         } else {
            var11 = var5.method2360(true);
         }

         if(this.field890 != 128 || this.field908 != 128) {
            var11.method2374(this.field890, this.field908, this.field890);
         }

         return var11;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "678326716"
   )
   public final ModelData method778() {
      if(null != this.field914) {
         NPCComposition var1 = this.method779();
         return null == var1?null:var1.method778();
      } else if(null == this.field884) {
         return null;
      } else {
         boolean var5 = false;

         for(int var6 = 0; var6 < this.field884.length; ++var6) {
            if(!field885.method3292(this.field884[var6], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field884.length];

            for(int var3 = 0; var3 < this.field884.length; ++var3) {
               var2[var3] = ModelData.method2262(field885, this.field884[var3], 0);
            }

            ModelData var7;
            if(var2.length == 1) {
               var7 = var2[0];
            } else {
               var7 = new ModelData(var2, var2.length);
            }

            int var4;
            if(null != this.field900) {
               for(var4 = 0; var4 < this.field900.length; ++var4) {
                  var7.method2337(this.field900[var4], this.field901[var4]);
               }
            }

            if(null != this.field899) {
               for(var4 = 0; var4 < this.field899.length; ++var4) {
                  var7.method2276(this.field899[var4], this.field903[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "1469662836"
   )
   public final NPCComposition method779() {
      int var1 = -1;
      if(this.field915 != -1) {
         var1 = Sequence.method901(this.field915);
      } else if(this.field897 != -1) {
         var1 = class179.widgetSettings[this.field897];
      }

      return var1 >= 0 && var1 < this.field914.length && this.field914[var1] != -1?GroundObject.getNpcDefinition(this.field914[var1]):null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1009419415"
   )
   public boolean method780() {
      if(null == this.field914) {
         return true;
      } else {
         int var1 = -1;
         if(this.field915 != -1) {
            var1 = Sequence.method901(this.field915);
         } else if(this.field897 != -1) {
            var1 = class179.widgetSettings[this.field897];
         }

         return var1 >= 0 && var1 < this.field914.length && this.field914[var1] != -1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "29807390"
   )
   void method790(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method776(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1637882709"
   )
   void method796() {
   }
}
