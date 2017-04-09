import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("s")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 752689699
   )
   int field104 = -1;
   @ObfuscatedName("u")
   int[] field105;
   @ObfuscatedName("ef")
   static SpritePixels[] field108;
   @ObfuscatedName("f")
   Script field111;
   @ObfuscatedName("h")
   String[] field112;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -20437081
   )
   static int field113;

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "1845996340"
   )
   static void method143(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2226 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2226 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2226 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.field2227 == 0) {
         var0.height = var0.field2231;
      } else if(var0.field2227 == 1) {
         var0.height = var2 - var0.field2231;
      } else if(var0.field2227 == 2) {
         var0.height = var2 * var0.field2231 >> 14;
      }

      if(var0.field2226 == 4) {
         var0.width = var0.height * var0.field2236 / var0.field2278;
      }

      if(var0.field2227 == 4) {
         var0.height = var0.width * var0.field2278 / var0.field2236;
      }

      if(Client.field473 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field475 = var0;
      }

      if(var3 && var0.field2341 != null && (var0.width != var4 || var5 != var0.height)) {
         class18 var6 = new class18();
         var6.field207 = var0;
         var6.field199 = var0.field2341;
         Client.field502.method2459(var6);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1129401170"
   )
   static final void method144() {
      for(int var0 = 0; var0 < Client.field545; ++var0) {
         --Client.field334[var0];
         if(Client.field334[var0] >= -10) {
            SoundEffect var10 = Client.field550[var0];
            if(var10 == null) {
               Object var2 = null;
               var10 = SoundEffect.method1013(IndexFile.indexSoundEffects, Client.field546[var0], 0);
               if(var10 == null) {
                  continue;
               }

               Client.field334[var0] += var10.method1003();
               Client.field550[var0] = var10;
            }

            if(Client.field334[var0] < 0) {
               int var11;
               if(Client.field464[var0] != 0) {
                  int var3 = (Client.field464[var0] & 255) * 128;
                  int var4 = Client.field464[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - Projectile.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field464[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - Projectile.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     Client.field334[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var11 = (var3 - var8) * Client.field544 / var3;
               } else {
                  var11 = Client.field543;
               }

               if(var11 > 0) {
                  class55 var12 = var10.method1008().method1054(class118.field1868);
                  class66 var13 = class66.method1211(var12, 100, var11);
                  var13.method1217(Client.field547[var0] - 1);
                  Ignore.field224.method942(var13);
               }

               Client.field334[var0] = -100;
            }
         } else {
            --Client.field545;

            for(int var1 = var0; var1 < Client.field545; ++var1) {
               Client.field546[var1] = Client.field546[var1 + 1];
               Client.field550[var1] = Client.field550[var1 + 1];
               Client.field547[var1] = Client.field547[var1 + 1];
               Client.field334[var1] = Client.field334[var1 + 1];
               Client.field464[var1] = Client.field464[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field542) {
         boolean var9;
         if(class138.field1940 != 0) {
            var9 = true;
         } else {
            var9 = class138.field1939.method2555();
         }

         if(!var9) {
            if(Client.field540 != 0 && Client.field541 != -1) {
               TextureProvider.method1487(Client.indexTrack1, Client.field541, 0, Client.field540, false);
            }

            Client.field542 = false;
         }
      }

   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "96"
   )
   static final boolean method145() {
      if(class20.field233 == null) {
         return false;
      } else {
         int var0;
         String var1;
         try {
            int var2 = class20.field233.method2108();
            if(var2 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               class20.field233.method2104(Client.secretCipherBuffer2.payload, 0, 1);
               Client.secretCipherBuffer2.offset = 0;
               Client.packetOpcode = Client.secretCipherBuffer2.readOpcode();
               Client.field348 = class212.field3154[Client.packetOpcode];
               --var2;
            }

            if(Client.field348 == -1) {
               if(var2 <= 0) {
                  return false;
               }

               class20.field233.method2104(Client.secretCipherBuffer2.payload, 0, 1);
               Client.field348 = Client.secretCipherBuffer2.payload[0] & 255;
               --var2;
            }

            if(Client.field348 == -2) {
               if(var2 <= 1) {
                  return false;
               }

               class20.field233.method2104(Client.secretCipherBuffer2.payload, 0, 2);
               Client.secretCipherBuffer2.offset = 0;
               Client.field348 = Client.secretCipherBuffer2.readUnsignedShort();
               var2 -= 2;
            }

            if(var2 < Client.field348) {
               return false;
            }

            Client.secretCipherBuffer2.offset = 0;
            class20.field233.method2104(Client.secretCipherBuffer2.payload, 0, Client.field348);
            Client.field350 = 0;
            Client.field354 = Client.field424;
            Client.field424 = Client.field352 * -1;
            Client.field352 = Client.packetOpcode * -1;
            int var3;
            String var4;
            if(Client.packetOpcode == 5) {
               var3 = Client.secretCipherBuffer2.method3015();
               var0 = Client.secretCipherBuffer2.method3051();
               var4 = Client.secretCipherBuffer2.readString();
               if(var3 >= 1 && var3 <= 8) {
                  if(var4.equalsIgnoreCase("null")) {
                     var4 = null;
                  }

                  Client.playerOptions[var3 - 1] = var4;
                  Client.playerOptionsPriority[var3 - 1] = var0 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 114) {
               MessageNode.field250 = Client.secretCipherBuffer2.readUnsignedByte();
               class119.field1880 = Client.secretCipherBuffer2.method3051();

               while(Client.secretCipherBuffer2.offset < Client.field348) {
                  Client.packetOpcode = Client.secretCipherBuffer2.readUnsignedByte();
                  class60.method1179();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 238) {
               class30.method640();
               Client.energy = Client.secretCipherBuffer2.readUnsignedByte();
               Client.field500 = Client.field561;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var5;
            Widget var6;
            if(Client.packetOpcode == 9) {
               var5 = Client.secretCipherBuffer2.readUnsignedByte() == 1;
               var0 = Client.secretCipherBuffer2.method2912();
               var6 = FaceNormal.method1932(var0);
               if(var5 != var6.isHidden) {
                  var6.isHidden = var5;
                  class22.method197(var6);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 7) {
               var1 = Client.secretCipherBuffer2.readString();
               var0 = Client.secretCipherBuffer2.method3006();
               var6 = FaceNormal.method1932(var0);
               if(!var1.equals(var6.text)) {
                  var6.text = var1;
                  class22.method197(var6);
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var7;
            int var9;
            long var10;
            boolean var12;
            long var13;
            int var15;
            int var16;
            if(Client.packetOpcode == 213) {
               Client.field497 = Client.field561;
               if(Client.field348 == 0) {
                  Client.field530 = null;
                  Client.clanChatOwner = null;
                  VertexNormal.clanChatCount = 0;
                  class156.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.clanChatOwner = Client.secretCipherBuffer2.readString();
               long var58 = Client.secretCipherBuffer2.readLong();
               var7 = var58;
               if(var58 > 0L && var58 < 6582952005840035281L) {
                  if(0L == var58 % 37L) {
                     var4 = null;
                  } else {
                     var9 = 0;

                     for(var10 = var58; 0L != var10; var10 /= 37L) {
                        ++var9;
                     }

                     StringBuilder var55 = new StringBuilder(var9);

                     while(0L != var7) {
                        var13 = var7;
                        var7 /= 37L;
                        var55.append(class205.field3092[(int)(var13 - var7 * 37L)]);
                     }

                     var4 = var55.reverse().toString();
                  }
               } else {
                  var4 = null;
               }

               Client.field530 = var4;
               class47.field959 = Client.secretCipherBuffer2.readByte();
               var9 = Client.secretCipherBuffer2.readUnsignedByte();
               if(var9 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               VertexNormal.clanChatCount = var9;
               XClanMember[] var56 = new XClanMember[100];

               for(var16 = 0; var16 < VertexNormal.clanChatCount; ++var16) {
                  var56[var16] = new XClanMember();
                  var56[var16].username = Client.secretCipherBuffer2.readString();
                  var56[var16].field291 = class187.method3483(var56[var16].username, Ignore.field214);
                  var56[var16].world = Client.secretCipherBuffer2.readUnsignedShort();
                  var56[var16].rank = Client.secretCipherBuffer2.readByte();
                  Client.secretCipherBuffer2.readString();
                  if(var56[var16].username.equals(Projectile.localPlayer.name)) {
                     class9.field75 = var56[var16].rank;
                  }
               }

               var12 = false;
               var15 = VertexNormal.clanChatCount;

               while(var15 > 0) {
                  var12 = true;
                  --var15;

                  for(int var57 = 0; var57 < var15; ++var57) {
                     if(var56[var57].field291.compareTo(var56[var57 + 1].field291) > 0) {
                        XClanMember var64 = var56[var57];
                        var56[var57] = var56[var57 + 1];
                        var56[var57 + 1] = var64;
                        var12 = false;
                     }
                  }

                  if(var12) {
                     break;
                  }
               }

               class156.clanMembers = var56;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 103) {
               Client.field539 = Client.secretCipherBuffer2.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 48) {
               Client.field319 = Client.secretCipherBuffer2.method2904() * 30;
               Client.field500 = Client.field561;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 73) {
               var3 = Client.secretCipherBuffer2.method3006();
               var0 = Client.secretCipherBuffer2.readUnsignedShort();
               var6 = FaceNormal.method1932(var3);
               if(var6.modelType != 1 || var0 != var6.modelId) {
                  var6.modelType = 1;
                  var6.modelId = var0;
                  class22.method197(var6);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 88) {
               WallObject.method1930();
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 239) {
               Actor.method572(Client.secretCipherBuffer2, Client.field348);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 178) {
               class30.method640();
               Client.weight = Client.secretCipherBuffer2.readShort();
               Client.field500 = Client.field561;
               Client.packetOpcode = -1;
               return true;
            }

            int var17;
            int var18;
            Widget var19;
            if(Client.packetOpcode == 83) {
               var3 = Client.secretCipherBuffer2.method2853();
               var0 = Client.secretCipherBuffer2.method2853();
               var17 = Client.secretCipherBuffer2.readInt();
               var18 = Client.secretCipherBuffer2.method2904();
               var19 = FaceNormal.method1932(var17);
               if(var19.rotationX != var18 || var0 != var19.rotationZ || var19.field2320 != var3) {
                  var19.rotationX = var18;
                  var19.rotationZ = var0;
                  var19.field2320 = var3;
                  class22.method197(var19);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 136) {
               var3 = Client.secretCipherBuffer2.method2853();
               var0 = Client.secretCipherBuffer2.method3006();
               class165.settings[var3] = var0;
               if(class165.widgetSettings[var3] != var0) {
                  class165.widgetSettings[var3] = var0;
               }

               Client.method550(var3);
               Client.field489[++Client.field490 - 1 & 31] = var3;
               Client.packetOpcode = -1;
               return true;
            }

            Widget var20;
            if(Client.packetOpcode == 219) {
               var3 = Client.secretCipherBuffer2.readInt();
               var0 = Client.secretCipherBuffer2.method2913();
               var17 = Client.secretCipherBuffer2.method2853();
               if(var17 == '\uffff') {
                  var17 = -1;
               }

               var20 = FaceNormal.method1932(var0);
               ItemComposition var61;
               if(!var20.hasScript) {
                  if(var17 == -1) {
                     var20.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var61 = class196.getItemDefinition(var17);
                  var20.modelType = 4;
                  var20.modelId = var17;
                  var20.rotationX = var61.xan2d;
                  var20.rotationZ = var61.yan2d;
                  var20.field2320 = var61.zoom2d * 100 / var3;
                  class22.method197(var20);
               } else {
                  var20.item = var17;
                  var20.stackSize = var3;
                  var61 = class196.getItemDefinition(var17);
                  var20.rotationX = var61.xan2d;
                  var20.rotationZ = var61.yan2d;
                  var20.rotationY = var61.zan2d;
                  var20.field2268 = var61.offsetX2d;
                  var20.field2269 = var61.offsetY2d;
                  var20.field2320 = var61.zoom2d;
                  if(var61.isStackable == 1) {
                     var20.field2277 = 1;
                  } else {
                     var20.field2277 = 2;
                  }

                  if(var20.field2274 > 0) {
                     var20.field2320 = var20.field2320 * 32 / var20.field2274;
                  } else if(var20.originalWidth > 0) {
                     var20.field2320 = var20.field2320 * 32 / var20.originalWidth;
                  }

                  class22.method197(var20);
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var21;
            if(Client.packetOpcode == 30) {
               var3 = Client.secretCipherBuffer2.readInt();
               var0 = Client.secretCipherBuffer2.readUnsignedShort();
               if(var3 < -70000) {
                  var0 += '耀';
               }

               if(var3 >= 0) {
                  var6 = FaceNormal.method1932(var3);
               } else {
                  var6 = null;
               }

               for(; Client.secretCipherBuffer2.offset < Client.field348; FaceNormal.method1931(var0, var18, var21 - 1, var9)) {
                  var18 = Client.secretCipherBuffer2.method2880();
                  var21 = Client.secretCipherBuffer2.readUnsignedShort();
                  var9 = 0;
                  if(var21 != 0) {
                     var9 = Client.secretCipherBuffer2.readUnsignedByte();
                     if(var9 == 255) {
                        var9 = Client.secretCipherBuffer2.readInt();
                     }
                  }

                  if(var6 != null && var18 >= 0 && var18 < var6.itemIds.length) {
                     var6.itemIds[var18] = var21;
                     var6.itemQuantities[var18] = var9;
                  }
               }

               if(var6 != null) {
                  class22.method197(var6);
               }

               class30.method640();
               Client.interfaceItemTriggers[++Client.field492 - 1 & 31] = var0 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            long var22;
            long var24;
            if(Client.packetOpcode == 57) {
               var3 = Client.secretCipherBuffer2.readInt();
               var0 = Client.secretCipherBuffer2.readInt();
               if(class150.field2067 == null || !class150.field2067.isValid()) {
                  try {
                     Iterator var62 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var62.hasNext()) {
                        GarbageCollectorMXBean var65 = (GarbageCollectorMXBean)var62.next();
                        if(var65.isValid()) {
                           class150.field2067 = var65;
                           Client.field581 = -1L;
                           Client.field518 = -1L;
                        }
                     }
                  } catch (Throwable var52) {
                     ;
                  }
               }

               var24 = class45.method867();
               var21 = -1;
               if(class150.field2067 != null) {
                  var22 = class150.field2067.getCollectionTime();
                  if(-1L != Client.field518) {
                     long var63 = var22 - Client.field518;
                     var13 = var24 - Client.field581;
                     if(var13 != 0L) {
                        var21 = (int)(var63 * 100L / var13);
                     }
                  }

                  Client.field518 = var22;
                  Client.field581 = var24;
               }

               Client.secretCipherBuffer1.putOpcode(148);
               Client.secretCipherBuffer1.method2892(GameEngine.FPS);
               Client.secretCipherBuffer1.method2891(var21);
               Client.secretCipherBuffer1.method2950(var3);
               Client.secretCipherBuffer1.method2908(var0);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 139) {
               class119.field1880 = Client.secretCipherBuffer2.readUnsignedByte();
               MessageNode.field250 = Client.secretCipherBuffer2.method3051();

               for(var3 = class119.field1880; var3 < class119.field1880 + 8; ++var3) {
                  for(var0 = MessageNode.field250; var0 < MessageNode.field250 + 8; ++var0) {
                     if(Client.groundItemDeque[Sequence.plane][var3][var0] != null) {
                        Client.groundItemDeque[Sequence.plane][var3][var0] = null;
                        Client.groundItemSpawned(var3, var0);
                     }
                  }
               }

               for(class25 var60 = (class25)Client.field461.method2464(); var60 != null; var60 = (class25)Client.field461.method2472()) {
                  if(var60.field599 >= class119.field1880 && var60.field599 < class119.field1880 + 8 && var60.field597 >= MessageNode.field250 && var60.field597 < MessageNode.field250 + 8 && Sequence.plane == var60.field601) {
                     var60.field598 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 41) {
               IndexDataBase.xteaChanged(true);
               Client.secretCipherBuffer2.readOpcode();
               var3 = Client.secretCipherBuffer2.readUnsignedShort();
               Actor.method572(Client.secretCipherBuffer2, var3);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 72) {
               Client.field571 = 1;
               Client.field496 = Client.field561;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 180) {
               class13.method160(true);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 16) {
               class119.field1880 = Client.secretCipherBuffer2.method3051();
               MessageNode.field250 = Client.secretCipherBuffer2.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 172) {
               World var59 = new World();
               var59.address = Client.secretCipherBuffer2.readString();
               var59.id = Client.secretCipherBuffer2.readUnsignedShort();
               var0 = Client.secretCipherBuffer2.readInt();
               var59.mask = var0;
               GameObject.setGameState(45);
               class20.field233.method2113();
               class20.field233 = null;
               class142.method2750(var59);
               Client.packetOpcode = -1;
               return false;
            }

            WidgetNode var26;
            int var27;
            if(Client.packetOpcode == 158) {
               var3 = Client.field348 + Client.secretCipherBuffer2.offset;
               var0 = Client.secretCipherBuffer2.readUnsignedShort();
               var17 = Client.secretCipherBuffer2.readUnsignedShort();
               if(var0 != Client.widgetRoot) {
                  Client.widgetRoot = var0;
                  var18 = Client.widgetRoot;
                  var21 = class32.field755;
                  var9 = class168.field2207;
                  if(Ignore.method178(var18)) {
                     class65.method1205(Widget.widgets[var18], -1, var21, var9, false);
                  }

                  class176.method3314(Client.widgetRoot);
                  class114.method2257(Client.widgetRoot);

                  for(var18 = 0; var18 < 100; ++var18) {
                     Client.field508[var18] = true;
                  }
               }

               WidgetNode var67;
               for(; var17-- > 0; var67.field188 = true) {
                  var18 = Client.secretCipherBuffer2.readInt();
                  var21 = Client.secretCipherBuffer2.readUnsignedShort();
                  var9 = Client.secretCipherBuffer2.readUnsignedByte();
                  var67 = (WidgetNode)Client.componentTable.method2417((long)var18);
                  if(var67 != null && var67.id != var21) {
                     Item.method828(var67, true);
                     var67 = null;
                  }

                  if(var67 == null) {
                     var67 = class172.method3306(var18, var21, var9);
                  }
               }

               for(var26 = (WidgetNode)Client.componentTable.method2420(); var26 != null; var26 = (WidgetNode)Client.componentTable.method2422()) {
                  if(var26.field188) {
                     var26.field188 = false;
                  } else {
                     Item.method828(var26, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.secretCipherBuffer2.offset < var3) {
                  var18 = Client.secretCipherBuffer2.readInt();
                  var21 = Client.secretCipherBuffer2.readUnsignedShort();
                  var9 = Client.secretCipherBuffer2.readUnsignedShort();
                  var27 = Client.secretCipherBuffer2.readInt();

                  for(var16 = var21; var16 <= var9; ++var16) {
                     var24 = (long)var16 + ((long)var18 << 32);
                     Client.widgetFlags.method2418(new class133(var27), var24);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 106) {
               var3 = Client.secretCipherBuffer2.method2904();
               class1.method8(var3);
               Client.interfaceItemTriggers[++Client.field492 - 1 & 31] = var3 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 95) {
               var1 = Client.secretCipherBuffer2.readString();
               Object[] var66 = new Object[var1.length() + 1];

               for(var17 = var1.length() - 1; var17 >= 0; --var17) {
                  if(var1.charAt(var17) == 115) {
                     var66[var17 + 1] = Client.secretCipherBuffer2.readString();
                  } else {
                     var66[var17 + 1] = new Integer(Client.secretCipherBuffer2.readInt());
                  }
               }

               var66[0] = new Integer(Client.secretCipherBuffer2.readInt());
               class18 var68 = new class18();
               var68.field199 = var66;
               class26.method565(var68);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 67) {
               Client.field446 = true;
               class15.field172 = Client.secretCipherBuffer2.readUnsignedByte();
               class22.field254 = Client.secretCipherBuffer2.readUnsignedByte();
               Ignore.field216 = Client.secretCipherBuffer2.readUnsignedShort();
               class207.field3109 = Client.secretCipherBuffer2.readUnsignedByte();
               class5.field54 = Client.secretCipherBuffer2.readUnsignedByte();
               if(class5.field54 >= 100) {
                  MessageNode.cameraX = class15.field172 * 128 + 64;
                  DecorativeObject.cameraY = class22.field254 * 128 + 64;
                  class16.cameraZ = class103.method2025(MessageNode.cameraX, DecorativeObject.cameraY, Sequence.plane) - Ignore.field216;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 240) {
               var3 = Client.secretCipherBuffer2.method2913();
               var0 = Client.secretCipherBuffer2.readUnsignedShort();
               var17 = Client.secretCipherBuffer2.method3051();
               var26 = (WidgetNode)Client.componentTable.method2417((long)var3);
               if(var26 != null) {
                  Item.method828(var26, var0 != var26.id);
               }

               class172.method3306(var3, var0, var17);
               Client.packetOpcode = -1;
               return true;
            }

            int var28;
            CipherBuffer var29;
            String var30;
            String var31;
            int var32;
            if(Client.packetOpcode == 193) {
               var29 = Client.secretCipherBuffer2;
               var0 = Client.field348;
               ClassInfo var69 = new ClassInfo();
               var69.field3240 = var29.readUnsignedByte();
               var69.field3236 = var29.readInt();
               var69.field3237 = new int[var69.field3240];
               var69.field3235 = new int[var69.field3240];
               var69.fields = new Field[var69.field3240];
               var69.field3238 = new int[var69.field3240];
               var69.methods = new Method[var69.field3240];
               var69.args = new byte[var69.field3240][][];

               for(var18 = 0; var18 < var69.field3240; ++var18) {
                  try {
                     var21 = var29.readUnsignedByte();
                     String var83;
                     if(var21 != 0 && var21 != 1 && var21 != 2) {
                        if(var21 == 3 || var21 == 4) {
                           var31 = var29.readString();
                           var83 = var29.readString();
                           var16 = var29.readUnsignedByte();
                           String[] var74 = new String[var16];

                           for(var15 = 0; var15 < var16; ++var15) {
                              var74[var15] = var29.readString();
                           }

                           var30 = var29.readString();
                           byte[][] var84 = new byte[var16][];
                           int var79;
                           if(var21 == 3) {
                              for(var28 = 0; var28 < var16; ++var28) {
                                 var79 = var29.readInt();
                                 var84[var28] = new byte[var79];
                                 var29.readBytes(var84[var28], 0, var79);
                              }
                           }

                           var69.field3237[var18] = var21;
                           Class[] var81 = new Class[var16];

                           for(var79 = 0; var79 < var16; ++var79) {
                              var81[var79] = ClassInfo.method4259(var74[var79]);
                           }

                           Class var39 = ClassInfo.method4259(var30);
                           if(ClassInfo.method4259(var31).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var85 = ClassInfo.method4259(var31).getDeclaredMethods();
                           Method[] var86 = var85;

                           for(var32 = 0; var32 < var86.length; ++var32) {
                              Method var96 = var86[var32];
                              if(Reflection.getMethodName(var96).equals(var83)) {
                                 Class[] var94 = Reflection.getParameterTypes(var96);
                                 if(var81.length == var94.length) {
                                    boolean var92 = true;

                                    for(int var98 = 0; var98 < var81.length; ++var98) {
                                       if(var81[var98] != var94[var98]) {
                                          var92 = false;
                                          break;
                                       }
                                    }

                                    if(var92 && var39 == var96.getReturnType()) {
                                       var69.methods[var18] = var96;
                                    }
                                 }
                              }
                           }

                           var69.args[var18] = var84;
                        }
                     } else {
                        var31 = var29.readString();
                        var83 = var29.readString();
                        var16 = 0;
                        if(var21 == 1) {
                           var16 = var29.readInt();
                        }

                        var69.field3237[var18] = var21;
                        var69.field3238[var18] = var16;
                        if(ClassInfo.method4259(var31).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var69.fields[var18] = Reflection.findField(ClassInfo.method4259(var31), var83);
                     }
                  } catch (ClassNotFoundException var47) {
                     var69.field3235[var18] = -1;
                  } catch (SecurityException var48) {
                     var69.field3235[var18] = -2;
                  } catch (NullPointerException var49) {
                     var69.field3235[var18] = -3;
                  } catch (Exception var50) {
                     var69.field3235[var18] = -4;
                  } catch (Throwable var51) {
                     var69.field3235[var18] = -5;
                  }
               }

               class227.field3244.method2430(var69);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 214) {
               var3 = Client.secretCipherBuffer2.readUnsignedShort();
               var0 = Client.secretCipherBuffer2.readUnsignedByte();
               var17 = Client.secretCipherBuffer2.readUnsignedShort();
               if(Client.field543 != 0 && var0 != 0 && Client.field545 < 50) {
                  Client.field546[Client.field545] = var3;
                  Client.field547[Client.field545] = var0;
                  Client.field334[Client.field545] = var17;
                  Client.field550[Client.field545] = null;
                  Client.field464[Client.field545] = 0;
                  ++Client.field545;
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var33;
            boolean var34;
            if(Client.packetOpcode == 232) {
               var3 = Client.secretCipherBuffer2.method2880();
               var33 = Client.secretCipherBuffer2.readUnsignedByte() == 1;
               var4 = "";
               var34 = false;
               if(var33) {
                  var4 = Client.secretCipherBuffer2.readString();
                  if(class94.method1951(var4)) {
                     var34 = true;
                  }
               }

               var31 = Client.secretCipherBuffer2.readString();
               if(!var34) {
                  Player.sendGameMessage(var3, var4, var31);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 207) {
               var3 = Client.secretCipherBuffer2.readUnsignedByte();
               if(Client.secretCipherBuffer2.readUnsignedByte() == 0) {
                  Client.grandExchangeOffers[var3] = new XGrandExchangeOffer();
                  Client.secretCipherBuffer2.offset += 18;
               } else {
                  --Client.secretCipherBuffer2.offset;
                  Client.grandExchangeOffers[var3] = new XGrandExchangeOffer(Client.secretCipherBuffer2, false);
               }

               Client.field498 = Client.field561;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 204) {
               var5 = Client.secretCipherBuffer2.readUnsignedByte() == 1;
               if(var5) {
                  class103.field1698 = class45.method867() - Client.secretCipherBuffer2.readLong();
                  class13.field138 = new class1(Client.secretCipherBuffer2, true);
               } else {
                  class13.field138 = null;
               }

               Client.field499 = Client.field561;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 124) {
               Client.secretCipherBuffer2.offset += 28;
               if(Client.secretCipherBuffer2.method2943()) {
                  var29 = Client.secretCipherBuffer2;
                  var0 = Client.secretCipherBuffer2.offset - 28;
                  class181.method3332(var29.payload, var0);
                  if(class104.field1712 != null) {
                     try {
                        class104.field1712.method1437(0L);
                        class104.field1712.method1443(var29.payload, var0, 24);
                     } catch (Exception var46) {
                        ;
                     }
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 190) {
               Client.field446 = false;

               for(var3 = 0; var3 < 5; ++var3) {
                  Client.field552[var3] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 228) {
               if(Client.widgetRoot != -1) {
                  class33.method718(Client.widgetRoot, 0);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 244) {
               var3 = Client.secretCipherBuffer2.method2853();
               var0 = Client.secretCipherBuffer2.readInt();
               var6 = FaceNormal.method1932(var0);
               if(var6 != null && var6.type == 0) {
                  if(var3 > var6.scrollHeight - var6.height) {
                     var3 = var6.scrollHeight - var6.height;
                  }

                  if(var3 < 0) {
                     var3 = 0;
                  }

                  if(var3 != var6.scrollY) {
                     var6.scrollY = var3;
                     class22.method197(var6);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 113) {
               var1 = Client.secretCipherBuffer2.readString();
               var0 = Client.secretCipherBuffer2.readUnsignedShort();
               byte var73 = Client.secretCipherBuffer2.readByte();
               var34 = false;
               if(var73 == -128) {
                  var34 = true;
               }

               if(var34) {
                  if(VertexNormal.clanChatCount == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  boolean var82 = false;

                  for(var21 = 0; var21 < VertexNormal.clanChatCount && (!class156.clanMembers[var21].username.equals(var1) || var0 != class156.clanMembers[var21].world); ++var21) {
                     ;
                  }

                  if(var21 < VertexNormal.clanChatCount) {
                     while(var21 < VertexNormal.clanChatCount - 1) {
                        class156.clanMembers[var21] = class156.clanMembers[var21 + 1];
                        ++var21;
                     }

                     --VertexNormal.clanChatCount;
                     class156.clanMembers[VertexNormal.clanChatCount] = null;
                  }
               } else {
                  Client.secretCipherBuffer2.readString();
                  XClanMember var80 = new XClanMember();
                  var80.username = var1;
                  var80.field291 = class187.method3483(var80.username, Ignore.field214);
                  var80.world = var0;
                  var80.rank = var73;

                  for(var9 = VertexNormal.clanChatCount - 1; var9 >= 0; --var9) {
                     var27 = class156.clanMembers[var9].field291.compareTo(var80.field291);
                     if(var27 == 0) {
                        class156.clanMembers[var9].world = var0;
                        class156.clanMembers[var9].rank = var73;
                        if(var1.equals(Projectile.localPlayer.name)) {
                           class9.field75 = var73;
                        }

                        Client.field497 = Client.field561;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var27 < 0) {
                        break;
                     }
                  }

                  if(VertexNormal.clanChatCount >= class156.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var27 = VertexNormal.clanChatCount - 1; var27 > var9; --var27) {
                     class156.clanMembers[var27 + 1] = class156.clanMembers[var27];
                  }

                  if(VertexNormal.clanChatCount == 0) {
                     class156.clanMembers = new XClanMember[100];
                  }

                  class156.clanMembers[var9 + 1] = var80;
                  ++VertexNormal.clanChatCount;
                  if(var1.equals(Projectile.localPlayer.name)) {
                     class9.field75 = var73;
                  }
               }

               Client.field497 = Client.field561;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 161) {
               while(Client.secretCipherBuffer2.offset < Client.field348) {
                  var3 = Client.secretCipherBuffer2.readUnsignedByte();
                  var33 = (var3 & 1) == 1;
                  var4 = Client.secretCipherBuffer2.readString();
                  var31 = Client.secretCipherBuffer2.readString();
                  Client.secretCipherBuffer2.readString();

                  Ignore var72;
                  for(var21 = 0; var21 < Client.ignoreCount; ++var21) {
                     var72 = Client.ignores[var21];
                     if(var33) {
                        if(var31.equals(var72.name)) {
                           var72.name = var4;
                           var72.previousName = var31;
                           var4 = null;
                           break;
                        }
                     } else if(var4.equals(var72.name)) {
                        var72.name = var4;
                        var72.previousName = var31;
                        var4 = null;
                        break;
                     }
                  }

                  if(var4 != null && Client.ignoreCount < 400) {
                     var72 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var72;
                     var72.name = var4;
                     var72.previousName = var31;
                     ++Client.ignoreCount;
                  }
               }

               Client.field496 = Client.field561;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 66) {
               class13.method160(false);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 115) {
               class146.field2041 = ItemLayer.method1493(Client.secretCipherBuffer2.readUnsignedByte());
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 173) {
               Client.flagX = Client.secretCipherBuffer2.readUnsignedByte();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.secretCipherBuffer2.readUnsignedByte();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 51) {
               CombatInfoListHolder.method733();

               for(var3 = 0; var3 < 2048; ++var3) {
                  Client.cachedPlayers[var3] = null;
               }

               RSSocket.method2100(Client.secretCipherBuffer2);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 55) {
               var3 = Client.secretCipherBuffer2.readInt();
               var0 = Client.secretCipherBuffer2.method2853();
               var6 = FaceNormal.method1932(var3);
               if(var6.modelType != 2 || var0 != var6.modelId) {
                  var6.modelType = 2;
                  var6.modelId = var0;
                  class22.method197(var6);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 91) {
               var3 = Client.secretCipherBuffer2.method2903();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               if(var3 == -1 && !Client.field542) {
                  TextureProvider.method1486();
               } else if(var3 != -1 && var3 != Client.field541 && Client.field540 != 0 && !Client.field542) {
                  IndexData var71 = Client.indexTrack1;
                  var17 = Client.field540;
                  class138.field1940 = 1;
                  class149.field2061 = var71;
                  class138.field1941 = var3;
                  RSCanvas.field1777 = 0;
                  NPC.field783 = var17;
                  class138.field1938 = false;
                  class138.field1937 = 2;
               }

               Client.field541 = var3;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 164) {
               var3 = Client.secretCipherBuffer2.method2851();
               var0 = Client.secretCipherBuffer2.readUnsignedShort();
               if(var0 == '\uffff') {
                  var0 = -1;
               }

               if(Client.field540 != 0 && var0 != -1) {
                  TextureProvider.method1487(Friend.indexTrack2, var0, 0, Client.field540, false);
                  Client.field542 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 176) {
               for(var3 = 0; var3 < class187.field2789; ++var3) {
                  class187 var70 = class109.method2096(var3);
                  if(var70 != null) {
                     class165.settings[var3] = 0;
                     class165.widgetSettings[var3] = 0;
                  }
               }

               class30.method640();
               Client.field490 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 162 || Client.packetOpcode == 77 || Client.packetOpcode == 205 || Client.packetOpcode == 12 || Client.packetOpcode == 194 || Client.packetOpcode == 94 || Client.packetOpcode == 181 || Client.packetOpcode == 245 || Client.packetOpcode == 147 || Client.packetOpcode == 36) {
               class60.method1179();
               Client.packetOpcode = -1;
               return true;
            }

            Widget var35;
            if(Client.packetOpcode == 215) {
               var3 = Client.secretCipherBuffer2.method2912();
               var35 = FaceNormal.method1932(var3);
               var35.modelType = 3;
               var35.modelId = Projectile.localPlayer.composition.method3208();
               class22.method197(var35);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 159) {
               var3 = Client.secretCipherBuffer2.method2903();
               var0 = Client.secretCipherBuffer2.method2913();
               var17 = var3 >> 10 & 31;
               var18 = var3 >> 5 & 31;
               var21 = var3 & 31;
               var9 = (var17 << 19) + (var18 << 11) + (var21 << 3);
               Widget var77 = FaceNormal.method1932(var0);
               if(var9 != var77.textColor) {
                  var77.textColor = var9;
                  class22.method197(var77);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 135) {
               IndexDataBase.xteaChanged(false);
               Client.secretCipherBuffer2.readOpcode();
               var3 = Client.secretCipherBuffer2.readUnsignedShort();
               Actor.method572(Client.secretCipherBuffer2, var3);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 120) {
               Client.field320 = Client.secretCipherBuffer2.readUnsignedByte();
               if(Client.field320 == 1) {
                  Client.field341 = Client.secretCipherBuffer2.readUnsignedShort();
               }

               if(Client.field320 >= 2 && Client.field320 <= 6) {
                  if(Client.field320 == 2) {
                     Client.field501 = 64;
                     Client.field327 = 64;
                  }

                  if(Client.field320 == 3) {
                     Client.field501 = 0;
                     Client.field327 = 64;
                  }

                  if(Client.field320 == 4) {
                     Client.field501 = 128;
                     Client.field327 = 64;
                  }

                  if(Client.field320 == 5) {
                     Client.field501 = 64;
                     Client.field327 = 0;
                  }

                  if(Client.field320 == 6) {
                     Client.field501 = 64;
                     Client.field327 = 128;
                  }

                  Client.field320 = 2;
                  Client.field323 = Client.secretCipherBuffer2.readUnsignedShort();
                  Client.field393 = Client.secretCipherBuffer2.readUnsignedShort();
                  Client.field466 = Client.secretCipherBuffer2.readUnsignedByte();
               }

               if(Client.field320 == 10) {
                  Client.field322 = Client.secretCipherBuffer2.readUnsignedShort();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 153) {
               var3 = Client.secretCipherBuffer2.readInt();
               WidgetNode var75 = (WidgetNode)Client.componentTable.method2417((long)var3);
               if(var75 != null) {
                  Item.method828(var75, true);
               }

               if(Client.field467 != null) {
                  class22.method197(Client.field467);
                  Client.field467 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 126) {
               class30.method640();
               var3 = Client.secretCipherBuffer2.method3051();
               var0 = Client.secretCipherBuffer2.method2912();
               var17 = Client.secretCipherBuffer2.method3051();
               Client.skillExperiences[var17] = var0;
               Client.boostedSkillLevels[var17] = var3;
               Client.realSkillLevels[var17] = 1;

               for(var18 = 0; var18 < 98; ++var18) {
                  if(var0 >= class172.field2369[var18]) {
                     Client.realSkillLevels[var17] = var18 + 2;
                  }
               }

               Client.field493[++Client.field503 - 1 & 31] = var17;
               Client.packetOpcode = -1;
               return true;
            }

            String var36;
            if(Client.packetOpcode == 62) {
               var1 = Client.secretCipherBuffer2.readString();
               CipherBuffer var78 = Client.secretCipherBuffer2;
               var36 = IndexFile.method2305(var78, 32767);
               var31 = FontTypeFace.method3900(class94.method1954(var36));
               Player.sendGameMessage(6, var1, var31);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 134) {
               byte var76 = Client.secretCipherBuffer2.readByte();
               var0 = Client.secretCipherBuffer2.method2853();
               class165.settings[var0] = var76;
               if(class165.widgetSettings[var0] != var76) {
                  class165.widgetSettings[var0] = var76;
               }

               Client.method550(var0);
               Client.field489[++Client.field490 - 1 & 31] = var0;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 236) {
               var3 = Client.secretCipherBuffer2.readInt();
               var35 = FaceNormal.method1932(var3);

               for(var17 = 0; var17 < var35.itemIds.length; ++var17) {
                  var35.itemIds[var17] = -1;
                  var35.itemIds[var17] = 0;
               }

               class22.method197(var35);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 250) {
               class72.method1444(Client.secretCipherBuffer2.readString());
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 99) {
               var3 = Client.secretCipherBuffer2.readInt();
               var0 = Client.secretCipherBuffer2.method2939();
               var17 = Client.secretCipherBuffer2.readShort();
               var20 = FaceNormal.method1932(var3);
               if(var20.originalX != var0 || var20.originalY != var17 || var20.field2351 != 0 || var20.field2217 != 0) {
                  var20.originalX = var0;
                  var20.originalY = var17;
                  var20.field2351 = 0;
                  var20.field2217 = 0;
                  class22.method197(var20);
                  XGrandExchangeOffer.method54(var20);
                  if(var20.type == 0) {
                     class2.method16(Widget.widgets[var3 >> 16], var20, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            String var37;
            long var38;
            CipherBuffer var40;
            boolean var41;
            if(Client.packetOpcode == 86) {
               var1 = Client.secretCipherBuffer2.readString();
               var38 = (long)Client.secretCipherBuffer2.readUnsignedShort();
               var7 = (long)Client.secretCipherBuffer2.read24BitInt();
               class177 var95 = (class177)Client.method556(class3.method23(), Client.secretCipherBuffer2.readUnsignedByte());
               var10 = var7 + (var38 << 32);
               var41 = false;

               for(var15 = 0; var15 < 100; ++var15) {
                  if(Client.field524[var15] == var10) {
                     var41 = true;
                     break;
                  }
               }

               if(class94.method1951(var1)) {
                  var41 = true;
               }

               if(!var41 && Client.field421 == 0) {
                  Client.field524[Client.field525] = var10;
                  Client.field525 = (Client.field525 + 1) % 100;
                  var40 = Client.secretCipherBuffer2;
                  var30 = IndexFile.method2305(var40, 32767);
                  var37 = FontTypeFace.method3900(class94.method1954(var30));
                  byte var88;
                  if(var95.field2690) {
                     var88 = 7;
                  } else {
                     var88 = 3;
                  }

                  if(var95.field2695 != -1) {
                     Player.sendGameMessage(var88, class30.method648(var95.field2695) + var1, var37);
                  } else {
                     Player.sendGameMessage(var88, var1, var37);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 69) {
               for(var3 = 0; var3 < Client.cachedPlayers.length; ++var3) {
                  if(Client.cachedPlayers[var3] != null) {
                     Client.cachedPlayers[var3].animation = -1;
                  }
               }

               for(var3 = 0; var3 < Client.cachedNPCs.length; ++var3) {
                  if(Client.cachedNPCs[var3] != null) {
                     Client.cachedNPCs[var3].animation = -1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 35) {
               var3 = Client.secretCipherBuffer2.readUnsignedByte();
               var0 = Client.secretCipherBuffer2.readUnsignedByte();
               var17 = Client.secretCipherBuffer2.readUnsignedByte();
               var18 = Client.secretCipherBuffer2.readUnsignedByte();
               Client.field552[var3] = true;
               Client.field482[var3] = var0;
               Client.field356[var3] = var17;
               Client.field383[var3] = var18;
               Client.field413[var3] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 233) {
               for(var3 = 0; var3 < class165.widgetSettings.length; ++var3) {
                  if(class165.settings[var3] != class165.widgetSettings[var3]) {
                     class165.widgetSettings[var3] = class165.settings[var3];
                     Client.method550(var3);
                     Client.field489[++Client.field490 - 1 & 31] = var3;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 20) {
               var3 = Client.secretCipherBuffer2.method2939();
               var0 = Client.secretCipherBuffer2.method3006();
               var6 = FaceNormal.method1932(var0);
               if(var6.field2266 != var3 || var3 == -1) {
                  var6.field2266 = var3;
                  var6.field2344 = 0;
                  var6.field2342 = 0;
                  class22.method197(var6);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 221) {
               var3 = Client.secretCipherBuffer2.method2853();
               Client.widgetRoot = var3;
               var0 = Client.widgetRoot;
               var17 = class32.field755;
               var18 = class168.field2207;
               if(Ignore.method178(var0)) {
                  class65.method1205(Widget.widgets[var0], -1, var17, var18, false);
               }

               class176.method3314(var3);
               class114.method2257(Client.widgetRoot);

               for(var0 = 0; var0 < 100; ++var0) {
                  Client.field508[var0] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 242) {
               var3 = Client.secretCipherBuffer2.method3006();
               var0 = Client.secretCipherBuffer2.readInt();
               var17 = Client.secretCipherBuffer2.method2853();
               if(var17 == '\uffff') {
                  var17 = -1;
               }

               var18 = Client.secretCipherBuffer2.method2853();
               if(var18 == '\uffff') {
                  var18 = -1;
               }

               for(var21 = var18; var21 <= var17; ++var21) {
                  var22 = (long)var21 + ((long)var0 << 32);
                  Node var93 = Client.widgetFlags.method2417(var22);
                  if(var93 != null) {
                     var93.unlink();
                  }

                  Client.widgetFlags.method2418(new class133(var3), var22);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 209) {
               Client.field521 = Client.secretCipherBuffer2.readUnsignedByte();
               Client.field522 = Client.secretCipherBuffer2.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 146) {
               Client.field446 = true;
               IndexFile.field1839 = Client.secretCipherBuffer2.readUnsignedByte();
               Projectile.field900 = Client.secretCipherBuffer2.readUnsignedByte();
               class145.field2033 = Client.secretCipherBuffer2.readUnsignedShort();
               PlayerComposition.field2195 = Client.secretCipherBuffer2.readUnsignedByte();
               class37.field813 = Client.secretCipherBuffer2.readUnsignedByte();
               if(class37.field813 >= 100) {
                  var3 = IndexFile.field1839 * 128 + 64;
                  var0 = Projectile.field900 * 128 + 64;
                  var17 = class103.method2025(var3, var0, Sequence.plane) - class145.field2033;
                  var18 = var3 - MessageNode.cameraX;
                  var21 = var17 - class16.cameraZ;
                  var9 = var0 - DecorativeObject.cameraY;
                  var27 = (int)Math.sqrt((double)(var18 * var18 + var9 * var9));
                  class16.cameraPitch = (int)(Math.atan2((double)var21, (double)var27) * 325.949D) & 2047;
                  class9.cameraYaw = (int)(Math.atan2((double)var18, (double)var9) * -325.949D) & 2047;
                  if(class16.cameraPitch < 128) {
                     class16.cameraPitch = 128;
                  }

                  if(class16.cameraPitch > 383) {
                     class16.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 234) {
               var3 = Client.secretCipherBuffer2.method3006();
               var0 = Client.secretCipherBuffer2.readInt();
               WidgetNode var91 = (WidgetNode)Client.componentTable.method2417((long)var0);
               var26 = (WidgetNode)Client.componentTable.method2417((long)var3);
               if(var26 != null) {
                  Item.method828(var26, var91 == null || var91.id != var26.id);
               }

               if(var91 != null) {
                  var91.unlink();
                  Client.componentTable.method2418(var91, (long)var3);
               }

               var19 = FaceNormal.method1932(var0);
               if(var19 != null) {
                  class22.method197(var19);
               }

               var19 = FaceNormal.method1932(var3);
               if(var19 != null) {
                  class22.method197(var19);
                  class2.method16(Widget.widgets[var19.id >>> 16], var19, true);
               }

               if(Client.widgetRoot != -1) {
                  class33.method718(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 56) {
               var3 = Client.secretCipherBuffer2.readInt();
               var0 = Client.secretCipherBuffer2.readUnsignedShort();
               if(var3 < -70000) {
                  var0 += '耀';
               }

               if(var3 >= 0) {
                  var6 = FaceNormal.method1932(var3);
               } else {
                  var6 = null;
               }

               if(var6 != null) {
                  for(var18 = 0; var18 < var6.itemIds.length; ++var18) {
                     var6.itemIds[var18] = 0;
                     var6.itemQuantities[var18] = 0;
                  }
               }

               XItemContainer var89 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var0);
               if(var89 != null) {
                  for(var21 = 0; var21 < var89.itemIds.length; ++var21) {
                     var89.itemIds[var21] = -1;
                     var89.stackSizes[var21] = 0;
                  }
               }

               var18 = Client.secretCipherBuffer2.readUnsignedShort();

               for(var21 = 0; var21 < var18; ++var21) {
                  var9 = Client.secretCipherBuffer2.method3015();
                  if(var9 == 255) {
                     var9 = Client.secretCipherBuffer2.method2913();
                  }

                  var27 = Client.secretCipherBuffer2.method2903();
                  if(var6 != null && var21 < var6.itemIds.length) {
                     var6.itemIds[var21] = var27;
                     var6.itemQuantities[var21] = var9;
                  }

                  FaceNormal.method1931(var0, var21, var27 - 1, var9);
               }

               if(var6 != null) {
                  class22.method197(var6);
               }

               class30.method640();
               Client.interfaceItemTriggers[++Client.field492 - 1 & 31] = var0 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var42;
            if(Client.packetOpcode == 198) {
               Friend var87;
               Friend var90;
               while(Client.secretCipherBuffer2.offset < Client.field348) {
                  var5 = Client.secretCipherBuffer2.readUnsignedByte() == 1;
                  var36 = Client.secretCipherBuffer2.readString();
                  var4 = Client.secretCipherBuffer2.readString();
                  var18 = Client.secretCipherBuffer2.readUnsignedShort();
                  var21 = Client.secretCipherBuffer2.readUnsignedByte();
                  var9 = Client.secretCipherBuffer2.readUnsignedByte();
                  var41 = (var9 & 2) != 0;
                  var12 = (var9 & 1) != 0;
                  if(var18 > 0) {
                     Client.secretCipherBuffer2.readString();
                     Client.secretCipherBuffer2.readUnsignedByte();
                     Client.secretCipherBuffer2.readInt();
                  }

                  Client.secretCipherBuffer2.readString();

                  for(var32 = 0; var32 < Client.friendCount; ++var32) {
                     var90 = Client.friends[var32];
                     if(!var5) {
                        if(var36.equals(var90.name)) {
                           if(var90.world != var18) {
                              var42 = true;

                              for(class16 var45 = (class16)Client.field531.method2499(); var45 != null; var45 = (class16)Client.field531.method2500()) {
                                 if(var45.field178.equals(var36)) {
                                    if(var18 != 0 && var45.field182 == 0) {
                                       var45.method2511();
                                       var42 = false;
                                    } else if(var18 == 0 && var45.field182 != 0) {
                                       var45.method2511();
                                       var42 = false;
                                    }
                                 }
                              }

                              if(var42) {
                                 Client.field531.method2498(new class16(var36, var18));
                              }

                              var90.world = var18;
                           }

                           var90.previousName = var4;
                           var90.rank = var21;
                           var90.field157 = var41;
                           var90.field156 = var12;
                           var36 = null;
                           break;
                        }
                     } else if(var4.equals(var90.name)) {
                        var90.name = var36;
                        var90.previousName = var4;
                        var36 = null;
                        break;
                     }
                  }

                  if(var36 != null && Client.friendCount < 400) {
                     var87 = new Friend();
                     Client.friends[Client.friendCount] = var87;
                     var87.name = var36;
                     var87.previousName = var4;
                     var87.world = var18;
                     var87.rank = var21;
                     var87.field157 = var41;
                     var87.field156 = var12;
                     ++Client.friendCount;
                  }
               }

               Client.field571 = 2;
               Client.field496 = Client.field561;
               var5 = false;
               var0 = Client.friendCount;

               while(var0 > 0) {
                  var5 = true;
                  --var0;

                  for(var17 = 0; var17 < var0; ++var17) {
                     var34 = false;
                     Friend var97 = Client.friends[var17];
                     var87 = Client.friends[var17 + 1];
                     if(var97.world != Client.world && Client.world == var87.world) {
                        var34 = true;
                     }

                     if(!var34 && var97.world == 0 && var87.world != 0) {
                        var34 = true;
                     }

                     if(!var34 && !var97.field157 && var87.field157) {
                        var34 = true;
                     }

                     if(!var34 && !var97.field156 && var87.field156) {
                        var34 = true;
                     }

                     if(var34) {
                        var90 = Client.friends[var17];
                        Client.friends[var17] = Client.friends[var17 + 1];
                        Client.friends[var17 + 1] = var90;
                        var5 = false;
                     }
                  }

                  if(var5) {
                     break;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 206) {
               var3 = Client.secretCipherBuffer2.readUnsignedShort();
               var0 = Client.secretCipherBuffer2.readInt();
               var17 = Client.secretCipherBuffer2.method2903();
               var20 = FaceNormal.method1932(var0);
               var20.field2275 = var17 + (var3 << 16);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 63) {
               var1 = Client.secretCipherBuffer2.readString();
               var38 = Client.secretCipherBuffer2.readLong();
               var7 = (long)Client.secretCipherBuffer2.readUnsignedShort();
               var22 = (long)Client.secretCipherBuffer2.read24BitInt();
               class177 var43 = (class177)Client.method556(class3.method23(), Client.secretCipherBuffer2.readUnsignedByte());
               var24 = var22 + (var7 << 32);
               var42 = false;

               for(var28 = 0; var28 < 100; ++var28) {
                  if(var24 == Client.field524[var28]) {
                     var42 = true;
                     break;
                  }
               }

               if(var43.field2688 && class94.method1951(var1)) {
                  var42 = true;
               }

               if(!var42 && Client.field421 == 0) {
                  Client.field524[Client.field525] = var24;
                  Client.field525 = (Client.field525 + 1) % 100;
                  var40 = Client.secretCipherBuffer2;
                  var37 = IndexFile.method2305(var40, 32767);
                  String var44 = FontTypeFace.method3900(class94.method1954(var37));
                  if(var43.field2695 != -1) {
                     class216.addChatMessage(9, class30.method648(var43.field2695) + var1, var44, class7.method80(var38));
                  } else {
                     class216.addChatMessage(9, var1, var44, class7.method80(var38));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 174) {
               var3 = Client.secretCipherBuffer2.method2913();
               class36.field795 = class108.field1755.method2011(var3);
               Client.packetOpcode = -1;
               return true;
            }

            GameObject.method1958("" + Client.packetOpcode + "," + Client.field424 + "," + Client.field354 + "," + Client.field348, (Throwable)null);
            WallObject.method1930();
         } catch (IOException var53) {
            class107.method2083();
         } catch (Exception var54) {
            var1 = "" + Client.packetOpcode + "," + Client.field424 + "," + Client.field354 + "," + Client.field348 + "," + (class119.baseX + Projectile.localPlayer.pathX[0]) + "," + (class187.baseY + Projectile.localPlayer.pathY[0]) + ",";

            for(var0 = 0; var0 < Client.field348 && var0 < 50; ++var0) {
               var1 = var1 + Client.secretCipherBuffer2.payload[var0] + ",";
            }

            GameObject.method1958(var1, var54);
            WallObject.method1930();
         }

         return true;
      }
   }
}
