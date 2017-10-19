import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class81 {
   @ObfuscatedName("g")
   static int[] field1329;
   @ObfuscatedName("v")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("p")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("d")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 804708983
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lbx;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("a")
   static Calendar field1332;
   @ObfuscatedName("i")
   static final String[] field1338;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1094425107
   )
   static int field1337;
   @ObfuscatedName("q")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;

   static {
      field1329 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1332 = Calendar.getInstance();
      field1338 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1337 = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfg;IB)V",
      garbageValue = "113"
   )
   static final void method1665(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class94.field1496 = 0;
      Player.method1136(var0);

      for(int var3 = 0; var3 < class94.field1496; ++var3) {
         int var4 = class94.field1486[var3];
         Player var5 = Client.cachedPlayers[var4];
         int var6 = var0.readUnsignedByte();
         if((var6 & 1) != 0) {
            var6 += var0.readUnsignedByte() << 8;
         }

         byte var7 = -1;
         int var8;
         if((var6 & 64) != 0) {
            var8 = var0.readUnsignedByte();
            byte[] var9 = new byte[var8];
            Buffer var10 = new Buffer(var9);
            var0.method3271(var9, 0, var8);
            class94.field1488[var4] = var10;
            var5.decodeApperance(var10);
         }

         if((var6 & 512) != 0) {
            var5.field1251 = var0.method3252();
            var5.field1211 = var0.method3253();
            var5.field1252 = var0.method3251();
            var5.field1254 = var0.method3251();
            var5.field1240 = var0.readUnsignedShort() + Client.gameCycle;
            var5.field1256 = var0.readUnsignedShort() + Client.gameCycle;
            var5.field1257 = var0.method3259();
            if(var5.field886) {
               var5.field1251 += var5.field911;
               var5.field1211 += var5.field899;
               var5.field1252 += var5.field911;
               var5.field1254 += var5.field899;
               var5.queueSize = 0;
            } else {
               var5.field1251 += var5.pathX[0];
               var5.field1211 += var5.pathY[0];
               var5.field1252 += var5.pathX[0];
               var5.field1254 += var5.pathY[0];
               var5.queueSize = 1;
            }

            var5.field1213 = 0;
         }

         if((var6 & 16) != 0) {
            var5.overhead = var0.readString();
            if(var5.overhead.charAt(0) == '~') {
               var5.overhead = var5.overhead.substring(1);
               class174.sendGameMessage(2, var5.name, var5.overhead);
            } else if(var5 == class66.localPlayer) {
               class174.sendGameMessage(2, var5.name, var5.overhead);
            }

            var5.field1223 = false;
            var5.field1226 = 0;
            var5.field1247 = 0;
            var5.field1225 = 150;
         }

         int var17;
         if((var6 & 4) != 0) {
            var8 = var0.method3259();
            if(var8 == 65535) {
               var8 = -1;
            }

            var17 = var0.readUnsignedByte();
            ScriptVarType.method28(var5, var8, var17);
         }

         if((var6 & 256) != 0) {
            var7 = var0.method3251();
         }

         if((var6 & 32) != 0) {
            var5.field1249 = var0.readUnsignedShort();
            if(var5.queueSize == 0) {
               var5.orientation = var5.field1249;
               var5.field1249 = -1;
            }
         }

         if((var6 & 4096) != 0) {
            var5.graphic = var0.method3258();
            var8 = var0.method3267();
            var5.field1250 = var8 >> 16;
            var5.graphicsDelay = (var8 & 65535) + Client.gameCycle;
            var5.field1215 = 0;
            var5.field1248 = 0;
            if(var5.graphicsDelay > Client.gameCycle) {
               var5.field1215 = -1;
            }

            if(var5.graphic == 65535) {
               var5.graphic = -1;
            }
         }

         int var12;
         int var13;
         if((var6 & 8) != 0) {
            var8 = var0.method3258();
            Permission[] var20 = new Permission[]{Permission.field3171, Permission.field3170, Permission.field3174, Permission.field3178, Permission.field3173, Permission.field3177};
            Permission var21 = (Permission)class29.forOrdinal(var20, var0.readUnsignedByte());
            boolean var11 = var0.readUnsignedByte() == 1;
            var12 = var0.method3248();
            var13 = var0.offset;
            if(var5.name != null && var5.composition != null) {
               boolean var14 = false;
               if(var21.field3172 && class66.isIgnored(var5.name)) {
                  var14 = true;
               }

               if(!var14 && Client.field1033 == 0 && !var5.hidden) {
                  class94.field1484.offset = 0;
                  var0.method3270(class94.field1484.payload, 0, var12);
                  class94.field1484.offset = 0;
                  String var15 = FontTypeFace.appendTags(CombatInfoListHolder.method1692(class3.method7(class94.field1484)));
                  var5.overhead = var15.trim();
                  var5.field1226 = var8 >> 8;
                  var5.field1247 = var8 & 255;
                  var5.field1225 = 150;
                  var5.field1223 = var11;
                  var5.inSequence = var5 != class66.localPlayer && var21.field3172 && "" != Client.field990 && var15.toLowerCase().indexOf(Client.field990) == -1;
                  int var16;
                  if(var21.field3179) {
                     var16 = var11?91:1;
                  } else {
                     var16 = var11?90:2;
                  }

                  if(var21.field3176 != -1) {
                     class174.sendGameMessage(var16, AbstractByteBuffer.method3475(var21.field3176) + var5.name, var15);
                  } else {
                     class174.sendGameMessage(var16, var5.name, var15);
                  }
               }
            }

            var0.offset = var13 + var12;
         }

         if((var6 & 2048) != 0) {
            class94.field1487[var4] = var0.method3251();
         }

         if((var6 & 2) != 0) {
            var8 = var0.readUnsignedShortOb1();
            int var18;
            int var23;
            int var24;
            if(var8 > 0) {
               for(var17 = 0; var17 < var8; ++var17) {
                  var23 = -1;
                  var12 = -1;
                  var13 = -1;
                  var18 = var0.getUSmart();
                  if(var18 == 32767) {
                     var18 = var0.getUSmart();
                     var12 = var0.getUSmart();
                     var23 = var0.getUSmart();
                     var13 = var0.getUSmart();
                  } else if(var18 != 32766) {
                     var12 = var0.getUSmart();
                  } else {
                     var18 = -1;
                  }

                  var24 = var0.getUSmart();
                  var5.method1528(var18, var12, var23, var13, Client.gameCycle, var24);
               }
            }

            var17 = var0.method3248();
            if(var17 > 0) {
               for(var18 = 0; var18 < var17; ++var18) {
                  var23 = var0.getUSmart();
                  var12 = var0.getUSmart();
                  if(var12 != 32767) {
                     var13 = var0.getUSmart();
                     var24 = var0.method3248();
                     int var19 = var12 > 0?var0.method3248():var24;
                     var5.method1529(var23, Client.gameCycle, var12, var13, var24, var19);
                  } else {
                     var5.method1531(var23);
                  }
               }
            }
         }

         if((var6 & 128) != 0) {
            var5.interacting = var0.method3258();
            if(var5.interacting == 65535) {
               var5.interacting = -1;
            }
         }

         if((var6 & 1024) != 0) {
            for(var8 = 0; var8 < 3; ++var8) {
               var5.actions[var8] = var0.readString();
            }
         }

         if(var5.field886) {
            if(var7 == 127) {
               var5.method1114(var5.field911, var5.field899);
            } else {
               byte var22;
               if(var7 != -1) {
                  var22 = var7;
               } else {
                  var22 = class94.field1487[var4];
               }

               var5.method1118(var5.field911, var5.field899, var22);
            }
         }
      }

      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }
}
