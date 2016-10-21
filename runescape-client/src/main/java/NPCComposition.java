import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("n")
   static NodeCache field885 = new NodeCache(64);
   @ObfuscatedName("t")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1533403557
   )
   @Export("id")
   public int id;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 477041815
   )
   public int field888 = 32;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 820468891
   )
   public int field889 = -1;
   @ObfuscatedName("k")
   @Export("models")
   int[] models;
   @ObfuscatedName("c")
   int[] field891;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1506079183
   )
   public int field892 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1864358193
   )
   public int field893 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 959982345
   )
   public int field894 = 1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1023031743
   )
   public int field895 = -1;
   @ObfuscatedName("q")
   short[] field896;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1418728085
   )
   public int field897 = -1;
   @ObfuscatedName("aq")
   public boolean field898 = false;
   @ObfuscatedName("o")
   short[] field899;
   @ObfuscatedName("j")
   short[] field900;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1424192911
   )
   int field901 = 0;
   @ObfuscatedName("r")
   short[] field902;
   @ObfuscatedName("a")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("z")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1209250639
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("f")
   public static class170 field906;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -407297723
   )
   int field907 = 128;
   @ObfuscatedName("g")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1773411387
   )
   int field909 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 639141487
   )
   int field910 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -211827001
   )
   public int field911 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -826570139
   )
   public int field912 = -1;
   @ObfuscatedName("ar")
   public int[] field913;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1034346349
   )
   int field914 = -1;
   @ObfuscatedName("b")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("aw")
   public boolean field916 = true;
   @ObfuscatedName("am")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1120807059
   )
   int field918 = 128;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -127313895
   )
   public int field919 = -1;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1394520298"
   )
   void method794(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method795(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "555086766"
   )
   void method795(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2656();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.method2535();
         }
      } else if(var2 == 2) {
         this.name = var1.method2541();
      } else if(var2 == 12) {
         this.field894 = var1.method2656();
      } else if(var2 == 13) {
         this.field889 = var1.method2535();
      } else if(var2 == 14) {
         this.field895 = var1.method2535();
      } else if(var2 == 15) {
         this.field912 = var1.method2535();
      } else if(var2 == 16) {
         this.field919 = var1.method2535();
      } else if(var2 == 17) {
         this.field895 = var1.method2535();
         this.field893 = var1.method2535();
         this.field897 = var1.method2535();
         this.field892 = var1.method2535();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2541();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2656();
         this.field899 = new short[var3];
         this.field900 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field899[var4] = (short)var1.method2535();
            this.field900[var4] = (short)var1.method2535();
         }
      } else if(var2 == 41) {
         var3 = var1.method2656();
         this.field896 = new short[var3];
         this.field902 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field896[var4] = (short)var1.method2535();
            this.field902[var4] = (short)var1.method2535();
         }
      } else if(var2 == 60) {
         var3 = var1.method2656();
         this.field891 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field891[var4] = var1.method2535();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.method2535();
      } else if(var2 == 97) {
         this.field918 = var1.method2535();
      } else if(var2 == 98) {
         this.field907 = var1.method2535();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field909 = var1.method2534();
      } else if(var2 == 101) {
         this.field901 = var1.method2534() * 5;
      } else if(var2 == 102) {
         this.field911 = var1.method2535();
      } else if(var2 == 103) {
         this.field888 = var1.method2535();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field916 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field898 = true;
         }
      } else {
         this.field914 = var1.method2535();
         if(this.field914 == '\uffff') {
            this.field914 = -1;
         }

         this.field910 = var1.method2535();
         if(this.field910 == '\uffff') {
            this.field910 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.method2535();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.method2656();
         this.field913 = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field913[var5] = var1.method2535();
            if(this.field913[var5] == '\uffff') {
               this.field913[var5] = -1;
            }
         }

         this.field913[1 + var4] = var3;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-1980772858"
   )
   public final Model method796(Sequence var1, int var2, Sequence var3, int var4) {
      if(null != this.field913) {
         NPCComposition var12 = this.method798();
         return var12 == null?null:var12.method796(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var6 = false;

            for(int var10 = 0; var10 < this.models.length; ++var10) {
               if(!class145.field2224.method3353(this.models[var10], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2236(class145.field2224, this.models[var9], 0);
            }

            ModelData var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new ModelData(var8, var8.length);
            }

            if(this.field899 != null) {
               for(var9 = 0; var9 < this.field899.length; ++var9) {
                  var7.method2248(this.field899[var9], this.field900[var9]);
               }
            }

            if(this.field896 != null) {
               for(var9 = 0; var9 < this.field896.length; ++var9) {
                  var7.method2249(this.field896[var9], this.field902[var9]);
               }
            }

            var5 = var7.method2256(this.field909 + 64, this.field901 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var11;
         if(null != var1 && var3 != null) {
            var11 = var1.method885(var5, var2, var3, var4);
         } else if(null != var1) {
            var11 = var1.method882(var5, var2);
         } else if(var3 != null) {
            var11 = var3.method882(var5, var4);
         } else {
            var11 = var5.method2353(true);
         }

         if(this.field918 != 128 || this.field907 != 128) {
            var11.method2333(this.field918, this.field907, this.field918);
         }

         return var11;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2087319021"
   )
   void method797() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "1578368785"
   )
   public final NPCComposition method798() {
      int var1 = -1;
      if(this.field914 != -1) {
         var1 = class112.method2454(this.field914);
      } else if(this.field910 != -1) {
         var1 = class179.widgetSettings[this.field910];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field913.length - 1) {
         var2 = this.field913[var1];
      } else {
         var2 = this.field913[this.field913.length - 1];
      }

      return var2 != -1?World.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "470399217"
   )
   public boolean method799() {
      if(null == this.field913) {
         return true;
      } else {
         int var1 = -1;
         if(this.field914 != -1) {
            var1 = class112.method2454(this.field914);
         } else if(this.field910 != -1) {
            var1 = class179.widgetSettings[this.field910];
         }

         return var1 >= 0 && var1 < this.field913.length?this.field913[var1] != -1:this.field913[this.field913.length - 1] != -1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-397485771"
   )
   public final ModelData method810() {
      if(this.field913 != null) {
         NPCComposition var1 = this.method798();
         return null == var1?null:var1.method810();
      } else if(null == this.field891) {
         return null;
      } else {
         boolean var5 = false;

         for(int var6 = 0; var6 < this.field891.length; ++var6) {
            if(!class145.field2224.method3353(this.field891[var6], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field891.length];

            for(int var7 = 0; var7 < this.field891.length; ++var7) {
               var2[var7] = ModelData.method2236(class145.field2224, this.field891[var7], 0);
            }

            ModelData var3;
            if(var2.length == 1) {
               var3 = var2[0];
            } else {
               var3 = new ModelData(var2, var2.length);
            }

            int var4;
            if(this.field899 != null) {
               for(var4 = 0; var4 < this.field899.length; ++var4) {
                  var3.method2248(this.field899[var4], this.field900[var4]);
               }
            }

            if(this.field896 != null) {
               for(var4 = 0; var4 < this.field896.length; ++var4) {
                  var3.method2249(this.field896[var4], this.field902[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1873"
   )
   static final void method819() {
      for(class16 var0 = (class16)Client.field413.method3890(); null != var0; var0 = (class16)Client.field413.method3892()) {
         if(var0.field238 == -1) {
            var0.field237 = 0;
            ObjectComposition.method857(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1590012516"
   )
   static final void method820(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)Client.field413.method3890(); null != var10; var10 = (class16)Client.field413.method3892()) {
         if(var10.field234 == var0 && var1 == var10.field229 && var2 == var10.field230 && var10.field231 == var3) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class16();
         var9.field234 = var0;
         var9.field231 = var3;
         var9.field229 = var1;
         var9.field230 = var2;
         ObjectComposition.method857(var9);
         Client.field413.method3886(var9);
      }

      var9.field228 = var4;
      var9.field236 = var5;
      var9.field239 = var6;
      var9.field237 = var7;
      var9.field238 = var8;
   }
}
