import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3615;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3604;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1783373607
   )
   @Export("id")
   public int id;
   @ObfuscatedName("x")
   @Export("name")
   public String name;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1273794187
   )
   public int field3625;
   @ObfuscatedName("l")
   @Export("models")
   int[] models;
   @ObfuscatedName("b")
   int[] field3611;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1949658793
   )
   public int field3612;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1296822259
   )
   public int field3635;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 77398513
   )
   public int field3603;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1371183223
   )
   public int field3607;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1992061237
   )
   public int field3616;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 455126361
   )
   public int field3617;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 657730623
   )
   public int field3608;
   @ObfuscatedName("h")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("u")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("r")
   short[] field3621;
   @ObfuscatedName("g")
   short[] field3609;
   @ObfuscatedName("z")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("o")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -969911283
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1982795003
   )
   int field3613;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -774178013
   )
   int field3627;
   @ObfuscatedName("q")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1311619879
   )
   int field3629;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1262360381
   )
   int field3630;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -182353105
   )
   public int field3631;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1680597377
   )
   public int field3632;
   @ObfuscatedName("as")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1056058115
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1785443559
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("av")
   public boolean field3614;
   @ObfuscatedName("ak")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("at")
   public boolean field3638;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   IterableHashTable field3639;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3625 = 1;
      this.field3612 = -1;
      this.field3635 = -1;
      this.field3603 = -1;
      this.field3607 = -1;
      this.field3616 = -1;
      this.field3617 = -1;
      this.field3608 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3613 = 128;
      this.field3627 = 128;
      this.isVisible = false;
      this.field3629 = 0;
      this.field3630 = 0;
      this.field3631 = -1;
      this.field3632 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3614 = true;
      this.isClickable = true;
      this.field3638 = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1734552526"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;B)V",
      garbageValue = "122"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4825(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfv;IB)V",
      garbageValue = "-30"
   )
   void method4825(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 12) {
         this.field3625 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3612 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3607 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3635 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3603 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3607 = var1.readUnsignedShort();
         this.field3616 = var1.readUnsignedShort();
         this.field3617 = var1.readUnsignedShort();
         this.field3608 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.colors = new short[var3];
         this.modifiedColors = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.colors[var4] = (short)var1.readUnsignedShort();
            this.modifiedColors[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3621 = new short[var3];
         this.field3609 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3621[var4] = (short)var1.readUnsignedShort();
            this.field3609[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3611 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3611[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3613 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3627 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3629 = var1.readByte();
      } else if(var2 == 101) {
         this.field3630 = var1.readByte();
      } else if(var2 == 102) {
         this.field3631 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3632 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3614 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3638 = true;
         } else if(var2 == 249) {
            this.field3639 = Tile.method2607(var1, this.field3639);
         }
      } else {
         this.varpIndex = var1.readUnsignedShort();
         if(this.varpIndex == 65535) {
            this.varpIndex = -1;
         }

         this.varp32Index = var1.readUnsignedShort();
         if(this.varp32Index == 65535) {
            this.varp32Index = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == 65535) {
               this.configs[var5] = -1;
            }
         }

         this.configs[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljf;ILjf;II)Len;",
      garbageValue = "2042987032"
   )
   public final Model method4826(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.transform();
         return var12 == null?null:var12.method4826(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3604.method4281(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2533(field3604, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.colors != null) {
               for(var9 = 0; var9 < this.colors.length; ++var9) {
                  var11.recolor(this.colors[var9], this.modifiedColors[var9]);
               }
            }

            if(this.field3621 != null) {
               for(var9 = 0; var9 < this.field3621.length; ++var9) {
                  var11.method2536(this.field3621[var9], this.field3609[var9]);
               }
            }

            var5 = var11.light(this.field3629 + 64, this.field3630 * 5 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4880(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4877(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4877(var5, var4);
         } else {
            var10 = var5.method2640(true);
         }

         if(this.field3613 != 128 || this.field3627 != 128) {
            var10.method2628(this.field3613, this.field3627, this.field3613);
         }

         return var10;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ldv;",
      garbageValue = "-1871342924"
   )
   public final ModelData method4847() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4847();
      } else if(this.field3611 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3611.length; ++var2) {
            if(!field3604.method4281(this.field3611[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3611.length];

            for(int var3 = 0; var3 < this.field3611.length; ++var3) {
               var6[var3] = ModelData.method2533(field3604, this.field3611[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.colors != null) {
               for(var4 = 0; var4 < this.colors.length; ++var4) {
                  var7.recolor(this.colors[var4], this.modifiedColors[var4]);
               }
            }

            if(this.field3621 != null) {
               for(var4 = 0; var4 < this.field3621.length; ++var4) {
                  var7.method2536(this.field3621[var4], this.field3609[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Ljc;",
      garbageValue = "1"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = Item.method1849(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class218.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class94.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1305471731"
   )
   public boolean method4831() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = Item.method1849(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class218.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-113"
   )
   public int method4830(int var1, int var2) {
      return Occluder.method2998(this.field3639, var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "177960075"
   )
   public String method4828(int var1, String var2) {
      return VertexNormal.method2702(this.field3639, var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "607663650"
   )
   public static int method4836(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = class184.method3552(var9);
         var8 = class184.method3552(var10);
         var9 = class22.method187(var9, var2);
         var10 = class22.method187(var10, var2);
         if(var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return class9.method50(var9, var2) - class9.method50(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var12 != var11 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var11 != var12) {
               return class9.method50(var11, var2) - class9.method50(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var13 != var12) {
               return class9.method50(var12, var2) - class9.method50(var13, var2);
            }
         }

         return 0;
      }
   }
}
