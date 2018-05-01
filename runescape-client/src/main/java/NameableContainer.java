import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
@Implements("NameableContainer")
public abstract class NameableContainer {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2036864173
   )
   final int field3849;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1906156027
   )
   @Export("count")
   int count;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("nameables")
   Nameable[] nameables;
   @ObfuscatedName("s")
   HashMap field3844;
   @ObfuscatedName("y")
   HashMap field3845;
   @ObfuscatedName("c")
   Comparator field3847;

   NameableContainer(int var1) {
      this.count = 0;
      this.field3847 = null;
      this.field3849 = var1;
      this.nameables = this.vmethod5514(var1);
      this.field3844 = new HashMap(var1 / 8);
      this.field3845 = new HashMap(var1 / 8);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lkg;",
      garbageValue = "1778408778"
   )
   abstract Nameable vmethod5513();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)[Lkg;",
      garbageValue = "0"
   )
   abstract Nameable[] vmethod5514(int var1);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "896498573"
   )
   public void method5363() {
      this.count = 0;
      Arrays.fill(this.nameables, (Object)null);
      this.field3844.clear();
      this.field3845.clear();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "436987222"
   )
   @Export("getCount")
   public int getCount() {
      return this.count;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1244123133"
   )
   public boolean method5365() {
      return this.count == this.field3849;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lkb;B)Z",
      garbageValue = "-103"
   )
   @Export("isMember")
   public boolean isMember(Name var1) {
      return !var1.isCleanNameValid()?false:(this.field3844.containsKey(var1)?true:this.field3845.containsKey(var1));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lkb;B)Lkg;",
      garbageValue = "44"
   )
   public Nameable method5367(Name var1) {
      Nameable var2 = this.method5368(var1);
      return var2 != null?var2:this.method5364(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;I)Lkg;",
      garbageValue = "-218704733"
   )
   Nameable method5368(Name var1) {
      return !var1.isCleanNameValid()?null:(Nameable)this.field3844.get(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkb;I)Lkg;",
      garbageValue = "1966282903"
   )
   Nameable method5364(Name var1) {
      return !var1.isCleanNameValid()?null:(Nameable)this.field3845.get(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lkb;I)Z",
      garbageValue = "577759477"
   )
   public final boolean method5369(Name var1) {
      Nameable var2 = this.method5368(var1);
      if(var2 == null) {
         return false;
      } else {
         this.method5415(var2);
         return true;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkg;B)V",
      garbageValue = "6"
   )
   final void method5415(Nameable var1) {
      int var2 = this.method5398(var1);
      if(var2 != -1) {
         this.method5402(var2);
         this.method5377(var1);
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lkb;I)Lkg;",
      garbageValue = "-387771737"
   )
   Nameable method5371(Name var1) {
      return this.method5372(var1, (Name)null);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lkb;Lkb;I)Lkg;",
      garbageValue = "1505776293"
   )
   Nameable method5372(Name var1, Name var2) {
      if(this.method5368(var1) != null) {
         throw new IllegalStateException();
      } else {
         Nameable var3 = this.vmethod5513();
         var3.method5325(var1, var2);
         this.method5378(var3);
         this.method5379(var3);
         return var3;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IB)Lkg;",
      garbageValue = "16"
   )
   @Export("get")
   public final Nameable get(int var1) {
      if(var1 >= 0 && var1 < this.count) {
         return this.nameables[var1];
      } else {
         throw new ArrayIndexOutOfBoundsException(var1);
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2016770314"
   )
   public final void method5362() {
      if(this.field3847 == null) {
         Arrays.sort(this.nameables, 0, this.count);
      } else {
         Arrays.sort(this.nameables, 0, this.count, this.field3847);
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lkg;Lkb;Lkb;I)V",
      garbageValue = "1434930517"
   )
   final void method5375(Nameable var1, Name var2, Name var3) {
      this.method5377(var1);
      var1.method5325(var2, var3);
      this.method5379(var1);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lkg;I)I",
      garbageValue = "-773449762"
   )
   final int method5398(Nameable var1) {
      for(int var2 = 0; var2 < this.count; ++var2) {
         if(this.nameables[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lkg;I)V",
      garbageValue = "-1002956193"
   )
   final void method5377(Nameable var1) {
      if(this.field3844.remove(var1.name) == null) {
         throw new IllegalStateException();
      } else {
         if(var1.field3832 != null) {
            this.field3845.remove(var1.field3832);
         }

      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lkg;I)V",
      garbageValue = "-1090314159"
   )
   final void method5378(Nameable var1) {
      this.nameables[++this.count - 1] = var1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lkg;I)V",
      garbageValue = "1396964934"
   )
   final void method5379(Nameable var1) {
      this.field3844.put(var1.name, var1);
      if(var1.field3832 != null) {
         Nameable var2 = (Nameable)this.field3845.put(var1.field3832, var1);
         if(var2 != null && var2 != var1) {
            var2.field3832 = null;
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "9"
   )
   final void method5402(int var1) {
      --this.count;
      if(var1 < this.count) {
         System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-54"
   )
   public final void method5400() {
      this.field3847 = null;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;I)V",
      garbageValue = "79333893"
   )
   public final void method5384(Comparator var1) {
      if(this.field3847 == null) {
         this.field3847 = var1;
      } else if(this.field3847 instanceof class297) {
         ((class297)this.field3847).method5340(var1);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgl;ILbd;II)V",
      garbageValue = "549657721"
   )
   static final void method5440(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      if((var3 & 1024) != 0) {
         var4 = var0.method3630();
      }

      if((var3 & 2048) != 0) {
         class93.field1416[var1] = var0.method3631();
      }

      int var5;
      if((var3 & 4096) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      int var6;
      if((var3 & 8) != 0) {
         var5 = var0.method3635();
         if(var5 == 65535) {
            var5 = -1;
         }

         var6 = var0.method3626();
         class163.method3290(var2, var5, var6);
      }

      if((var3 & 128) != 0) {
         var2.field1168 = var0.method3627();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1168;
            var2.field1168 = -1;
         }
      }

      if((var3 & 64) != 0) {
         var5 = var0.method3628();
         byte[] var15 = new byte[var5];
         Buffer var7 = new Buffer(var15);
         var0.method3778(var15, 0, var5);
         class93.field1404[var1] = var7;
         var2.decodeApperance(var7);
      }

      if((var3 & 256) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.readInt();
         var2.field1187 = var5 >> 16;
         var2.graphicsDelay = (var5 & 65535) + Client.gameCycle;
         var2.spotAnimFrame = 0;
         var2.spotAnimFrameCycle = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.spotAnimFrame = -1;
         }

         if(var2.graphic == 65535) {
            var2.graphic = -1;
         }
      }

      if((var3 & 1) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == 65535) {
            var2.interacting = -1;
         }
      }

      int var8;
      int var9;
      if((var3 & 16) != 0) {
         var5 = var0.readUnsignedShort();
         Permission var21 = (Permission)class185.forOrdinal(TextureProvider.method2688(), var0.readUnsignedShortOb1());
         boolean var16 = var0.readUnsignedByte() == 1;
         var8 = var0.readUnsignedShortOb1();
         var9 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var10 = false;
            if(var21.field3342 && CacheFile.friendManager.isIgnored(var2.name)) {
               var10 = true;
            }

            if(!var10 && Client.myPlayerIndex == 0 && !var2.hidden) {
               class93.field1402.offset = 0;
               var0.method3778(class93.field1402.payload, 0, var8);
               class93.field1402.offset = 0;
               Buffer var12 = class93.field1402;
               String var11 = ScriptState.method1131(var12, 32767);
               String var13 = FontTypeFace.appendTags(UnitPriceComparator.method138(var11));
               var2.overhead = var13.trim();
               var2.field1159 = var5 >> 8;
               var2.field1158 = var5 & 255;
               var2.overheadTextCyclesRemaining = 150;
               var2.field1191 = var16;
               var2.field1155 = var2 != class265.localPlayer && var21.field3342 && "" != Client.field1068 && var13.toLowerCase().indexOf(Client.field1068) == -1;
               int var14;
               if(var21.field3341) {
                  var14 = var16?91:1;
               } else {
                  var14 = var16?90:2;
               }

               if(var21.field3334 != -1) {
                  ChatPlayer.sendGameMessage(var14, class241.method4532(var21.field3334) + var2.name.getName(), var13);
               } else {
                  ChatPlayer.sendGameMessage(var14, var2.name.getName(), var13);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if((var3 & 512) != 0) {
         var2.field1182 = var0.method3586();
         var2.field1184 = var0.method3586();
         var2.field1174 = var0.method3631();
         var2.field1185 = var0.method3631();
         var2.field1186 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1139 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1188 = var0.readUnsignedShort();
         if(var2.field840) {
            var2.field1182 += var2.field842;
            var2.field1184 += var2.field839;
            var2.field1174 += var2.field842;
            var2.field1185 += var2.field839;
            var2.queueSize = 0;
         } else {
            var2.field1182 += var2.pathX[0];
            var2.field1184 += var2.pathY[0];
            var2.field1174 += var2.pathX[0];
            var2.field1185 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1178 = 0;
      }

      if((var3 & 2) != 0) {
         var5 = var0.method3626();
         int var17;
         int var20;
         int var22;
         if(var5 > 0) {
            for(var6 = 0; var6 < var5; ++var6) {
               var8 = -1;
               var9 = -1;
               var20 = -1;
               var22 = var0.getUSmart();
               if(var22 == 32767) {
                  var22 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var8 = var0.getUSmart();
                  var20 = var0.getUSmart();
               } else if(var22 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var22 = -1;
               }

               var17 = var0.getUSmart();
               var2.applyActorHitsplat(var22, var9, var8, var20, Client.gameCycle, var17);
            }
         }

         var6 = var0.method3628();
         if(var6 > 0) {
            for(var22 = 0; var22 < var6; ++var22) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var20 = var0.getUSmart();
                  var17 = var0.method3626();
                  int var18 = var9 > 0?var0.method3626():var17;
                  var2.setCombatInfo(var8, Client.gameCycle, var9, var20, var17, var18);
               } else {
                  var2.method1704(var8);
               }
            }
         }
      }

      if((var3 & 4) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == '~') {
            var2.overhead = var2.overhead.substring(1);
            ChatPlayer.sendGameMessage(2, var2.name.getName(), var2.overhead);
         } else if(var2 == class265.localPlayer) {
            ChatPlayer.sendGameMessage(2, var2.name.getName(), var2.overhead);
         }

         var2.field1191 = false;
         var2.field1159 = 0;
         var2.field1158 = 0;
         var2.overheadTextCyclesRemaining = 150;
      }

      if(var2.field840) {
         if(var4 == 127) {
            var2.method1250(var2.field842, var2.field839);
         } else {
            byte var19;
            if(var4 != -1) {
               var19 = var4;
            } else {
               var19 = class93.field1416[var1];
            }

            var2.method1216(var2.field842, var2.field839, var19);
         }
      }

   }
}
