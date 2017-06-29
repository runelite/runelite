import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1913953885
   )
   public int field3555;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -38259449
   )
   public int field3556;
   @ObfuscatedName("a")
   public static NodeCache field3557;
   @ObfuscatedName("t")
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1237779121
   )
   @Export("id")
   public int id;
   @ObfuscatedName("r")
   @Export("name")
   public String name;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 317390919
   )
   public int field3561;
   @ObfuscatedName("y")
   @Export("models")
   int[] models;
   @ObfuscatedName("j")
   int[] field3563;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -495140423
   )
   public int field3564;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -2102438313
   )
   int field3565;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1467154395
   )
   public int field3566;
   @ObfuscatedName("i")
   public static IndexDataBase field3567;
   @ObfuscatedName("f")
   short[] field3568;
   @ObfuscatedName("u")
   short[] field3569;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1185076453
   )
   public int field3570;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -764564825
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("p")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1480733679
   )
   public int field3573;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 217327357
   )
   int field3574;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 119119547
   )
   public int field3575;
   @ObfuscatedName("q")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1270588287
   )
   public int field3577;
   @ObfuscatedName("b")
   short[] field3578;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -430074587
   )
   int field3579;
   @ObfuscatedName("x")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 363848257
   )
   int field3581;
   @ObfuscatedName("n")
   short[] field3582;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -889846165
   )
   public int field3583;
   @ObfuscatedName("w")
   public static IndexDataBase field3584;
   @ObfuscatedName("an")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1245318559
   )
   int field3586;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 765643205
   )
   int field3587;
   @ObfuscatedName("ay")
   public boolean field3588;
   @ObfuscatedName("ao")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("as")
   public boolean field3590;
   @ObfuscatedName("ak")
   class186 field3591;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "84"
   )
   void method4642(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4643(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "976152575"
   )
   void method4643(Buffer var1, int var2) {
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
         this.field3561 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3564 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3556 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3555 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3566 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3556 = var1.readUnsignedShort();
         this.field3577 = var1.readUnsignedShort();
         this.field3575 = var1.readUnsignedShort();
         this.field3570 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3578 = new short[var3];
         this.field3568 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3578[var4] = (short)var1.readUnsignedShort();
            this.field3568[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3582 = new short[var3];
         this.field3569 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3582[var4] = (short)var1.readUnsignedShort();
            this.field3569[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3563 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3563[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3574 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3579 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3581 = var1.readByte();
      } else if(var2 == 101) {
         this.field3565 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3583 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3573 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3588 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3590 = true;
         } else if(var2 == 249) {
            this.field3591 = XClanMember.method1181(var1, this.field3591);
         }
      } else {
         this.field3586 = var1.readUnsignedShort();
         if(this.field3586 == '\uffff') {
            this.field3586 = -1;
         }

         this.field3587 = var1.readUnsignedShort();
         if(this.field3587 == '\uffff') {
            this.field3587 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == '\uffff') {
               this.configs[var5] = -1;
            }
         }

         this.configs[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-41"
   )
   public final ModelData method4645() {
      if(this.configs != null) {
         NPCComposition var1 = this.method4646();
         return var1 == null?null:var1.method4645();
      } else if(this.field3563 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3563.length; ++var2) {
            if(!field3584.method4116(this.field3563[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3563.length];

            for(int var3 = 0; var3 < this.field3563.length; ++var3) {
               var6[var3] = ModelData.method2414(field3584, this.field3563[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.field3578 != null) {
               for(var4 = 0; var4 < this.field3578.length; ++var4) {
                  var7.method2422(this.field3578[var4], this.field3568[var4]);
               }
            }

            if(this.field3582 != null) {
               for(var4 = 0; var4 < this.field3582.length; ++var4) {
                  var7.method2450(this.field3582[var4], this.field3569[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)LNPCComposition;",
      garbageValue = "-118"
   )
   public final NPCComposition method4646() {
      int var1 = -1;
      if(this.field3586 != -1) {
         var1 = WorldMapType1.method264(this.field3586);
      } else if(this.field3587 != -1) {
         var1 = class211.widgetSettings[this.field3587];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class35.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1684439139"
   )
   public int method4648(int var1, int var2) {
      return ChatLineBuffer.method1884(this.field3591, var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "876747637"
   )
   public String method4649(int var1, String var2) {
      return class92.method1733(this.field3591, var1, var2);
   }

   static {
      field3557 = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "1355057304"
   )
   public final Model method4651(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.method4646();
         return var12 == null?null:var12.method4651(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3584.method4116(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2414(field3584, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.field3578 != null) {
               for(var9 = 0; var9 < this.field3578.length; ++var9) {
                  var11.method2422(this.field3578[var9], this.field3568[var9]);
               }
            }

            if(this.field3582 != null) {
               for(var9 = 0; var9 < this.field3582.length; ++var9) {
                  var11.method2450(this.field3582[var9], this.field3569[var9]);
               }
            }

            var5 = var11.light(this.field3581 + 64, this.field3565 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4694(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4704(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4704(var5, var4);
         } else {
            var10 = var5.method2530(true);
         }

         if(this.field3574 != 128 || this.field3579 != 128) {
            var10.method2566(this.field3574, this.field3579, this.field3574);
         }

         return var10;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1755654608"
   )
   void method4661() {
   }

   NPCComposition() {
      this.name = "null";
      this.field3561 = 1;
      this.field3564 = -1;
      this.field3555 = -1;
      this.field3566 = -1;
      this.field3556 = -1;
      this.field3577 = -1;
      this.field3575 = -1;
      this.field3570 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3574 = 128;
      this.field3579 = 128;
      this.isVisible = false;
      this.field3581 = 0;
      this.field3565 = 0;
      this.field3583 = -1;
      this.field3573 = 32;
      this.field3586 = -1;
      this.field3587 = -1;
      this.field3588 = true;
      this.isClickable = true;
      this.field3590 = false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-109"
   )
   public boolean method4666() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3586 != -1) {
            var1 = WorldMapType1.method264(this.field3586);
         } else if(this.field3587 != -1) {
            var1 = class211.widgetSettings[this.field3587];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }
}
