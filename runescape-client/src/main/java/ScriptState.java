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

      if(var3 && null != var0.field2341 && (var0.width != var4 || var5 != var0.height)) {
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
            SoundEffect var9 = Client.field550[var0];
            if(null == var9) {
               Object var10000 = null;
               var9 = SoundEffect.method1013(IndexFile.indexSoundEffects, Client.field546[var0], 0);
               if(null == var9) {
                  continue;
               }

               Client.field334[var0] += var9.method1003();
               Client.field550[var0] = var9;
            }

            if(Client.field334[var0] < 0) {
               int var2;
               if(Client.field464[var0] != 0) {
                  int var3 = (Client.field464[var0] & 255) * 128;
                  int var10 = Client.field464[var0] >> 16 & 255;
                  int var5 = var10 * 128 + 64 - Projectile.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field464[var0] >> 8 & 255;
                  int var7 = 64 + var6 * 128 - Projectile.localPlayer.y;
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

                  var2 = (var3 - var8) * Client.field544 / var3;
               } else {
                  var2 = Client.field543;
               }

               if(var2 > 0) {
                  class55 var11 = var9.method1008().method1054(class118.field1868);
                  class66 var4 = class66.method1211(var11, 100, var2);
                  var4.method1217(Client.field547[var0] - 1);
                  Ignore.field224.method942(var4);
               }

               Client.field334[var0] = -100;
            }
         } else {
            --Client.field545;

            for(int var1 = var0; var1 < Client.field545; ++var1) {
               Client.field546[var1] = Client.field546[var1 + 1];
               Client.field550[var1] = Client.field550[1 + var1];
               Client.field547[var1] = Client.field547[var1 + 1];
               Client.field334[var1] = Client.field334[1 + var1];
               Client.field464[var1] = Client.field464[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field542) {
         boolean var12;
         if(class138.field1940 != 0) {
            var12 = true;
         } else {
            var12 = class138.field1939.method2555();
         }

         if(!var12) {
            if(Client.field540 != 0 && Client.field541 != -1) {
               TextureProvider.method1487(Client.field586, Client.field541, 0, Client.field540, false);
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
         int var2;
         String var21;
         try {
            int var0 = class20.field233.method2108();
            if(var0 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               class20.field233.method2104(Client.secretCipherBuffer2.payload, 0, 1);
               Client.secretCipherBuffer2.offset = 0;
               Client.packetOpcode = Client.secretCipherBuffer2.readOpcode();
               Client.field348 = class212.field3154[Client.packetOpcode];
               --var0;
            }

            if(Client.field348 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class20.field233.method2104(Client.secretCipherBuffer2.payload, 0, 1);
               Client.field348 = Client.secretCipherBuffer2.payload[0] & 255;
               --var0;
            }

            if(Client.field348 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class20.field233.method2104(Client.secretCipherBuffer2.payload, 0, 2);
               Client.secretCipherBuffer2.offset = 0;
               Client.field348 = Client.secretCipherBuffer2.readUnsignedShort();
               var0 -= 2;
            }

            if(var0 < Client.field348) {
               return false;
            }

            Client.secretCipherBuffer2.offset = 0;
            class20.field233.method2104(Client.secretCipherBuffer2.payload, 0, Client.field348);
            Client.field350 = 0;
            Client.field354 = Client.field424;
            Client.field424 = Client.field352 * -1;
            Client.field352 = Client.packetOpcode * -1;
            int var1;
            String var3;
            if(Client.packetOpcode == 5) {
               var1 = Client.secretCipherBuffer2.method3015();
               var2 = Client.secretCipherBuffer2.method3051();
               var3 = Client.secretCipherBuffer2.readString();
               if(var1 >= 1 && var1 <= 8) {
                  if(var3.equalsIgnoreCase("null")) {
                     var3 = null;
                  }

                  Client.playerOptions[var1 - 1] = var3;
                  Client.playerOptionsPriority[var1 - 1] = var2 == 0;
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

            boolean var59;
            Widget var60;
            if(Client.packetOpcode == 9) {
               var59 = Client.secretCipherBuffer2.readUnsignedByte() == 1;
               var2 = Client.secretCipherBuffer2.method2912();
               var60 = FaceNormal.method1932(var2);
               if(var59 != var60.isHidden) {
                  var60.isHidden = var59;
                  class22.method197(var60);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 7) {
               var21 = Client.secretCipherBuffer2.readString();
               var2 = Client.secretCipherBuffer2.method3006();
               var60 = FaceNormal.method1932(var2);
               if(!var21.equals(var60.text)) {
                  var60.text = var21;
                  class22.method197(var60);
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var4;
            int var6;
            long var7;
            boolean var8;
            long var10;
            int var25;
            int var70;
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
               long var22 = Client.secretCipherBuffer2.readLong();
               var4 = var22;
               if(var22 > 0L && var22 < 6582952005840035281L) {
                  if(0L == var22 % 37L) {
                     var3 = null;
                  } else {
                     var6 = 0;

                     for(var7 = var22; 0L != var7; var7 /= 37L) {
                        ++var6;
                     }

                     StringBuilder var74 = new StringBuilder(var6);

                     while(0L != var4) {
                        var10 = var4;
                        var4 /= 37L;
                        var74.append(class205.field3092[(int)(var10 - var4 * 37L)]);
                     }

                     var3 = var74.reverse().toString();
                  }
               } else {
                  var3 = null;
               }

               Client.field530 = var3;
               class47.field959 = Client.secretCipherBuffer2.readByte();
               var6 = Client.secretCipherBuffer2.readUnsignedByte();
               if(var6 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               VertexNormal.clanChatCount = var6;
               XClanMember[] var86 = new XClanMember[100];

               for(var70 = 0; var70 < VertexNormal.clanChatCount; ++var70) {
                  var86[var70] = new XClanMember();
                  var86[var70].username = Client.secretCipherBuffer2.readString();
                  var86[var70].field291 = class187.method3483(var86[var70].username, Ignore.field214);
                  var86[var70].world = Client.secretCipherBuffer2.readUnsignedShort();
                  var86[var70].rank = Client.secretCipherBuffer2.readByte();
                  Client.secretCipherBuffer2.readString();
                  if(var86[var70].username.equals(Projectile.localPlayer.name)) {
                     class9.field75 = var86[var70].rank;
                  }
               }

               var8 = false;
               var25 = VertexNormal.clanChatCount;

               while(var25 > 0) {
                  var8 = true;
                  --var25;

                  for(int var77 = 0; var77 < var25; ++var77) {
                     if(var86[var77].field291.compareTo(var86[1 + var77].field291) > 0) {
                        XClanMember var75 = var86[var77];
                        var86[var77] = var86[var77 + 1];
                        var86[1 + var77] = var75;
                        var8 = false;
                     }
                  }

                  if(var8) {
                     break;
                  }
               }

               class156.clanMembers = var86;
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
               var1 = Client.secretCipherBuffer2.method3006();
               var2 = Client.secretCipherBuffer2.readUnsignedShort();
               var60 = FaceNormal.method1932(var1);
               if(var60.modelType != 1 || var2 != var60.modelId) {
                  var60.modelType = 1;
                  var60.modelId = var2;
                  class22.method197(var60);
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

            int var26;
            int var27;
            Widget var63;
            if(Client.packetOpcode == 83) {
               var1 = Client.secretCipherBuffer2.method2853();
               var2 = Client.secretCipherBuffer2.method2853();
               var26 = Client.secretCipherBuffer2.readInt();
               var27 = Client.secretCipherBuffer2.method2904();
               var63 = FaceNormal.method1932(var26);
               if(var63.rotationX != var27 || var2 != var63.rotationZ || var63.field2320 != var1) {
                  var63.rotationX = var27;
                  var63.rotationZ = var2;
                  var63.field2320 = var1;
                  class22.method197(var63);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 136) {
               var1 = Client.secretCipherBuffer2.method2853();
               var2 = Client.secretCipherBuffer2.method3006();
               class165.settings[var1] = var2;
               if(class165.widgetSettings[var1] != var2) {
                  class165.widgetSettings[var1] = var2;
               }

               Client.method550(var1);
               Client.field489[++Client.field490 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            Widget var28;
            if(Client.packetOpcode == 219) {
               var1 = Client.secretCipherBuffer2.readInt();
               var2 = Client.secretCipherBuffer2.method2913();
               var26 = Client.secretCipherBuffer2.method2853();
               if(var26 == '\uffff') {
                  var26 = -1;
               }

               var28 = FaceNormal.method1932(var2);
               ItemComposition var67;
               if(!var28.hasScript) {
                  if(var26 == -1) {
                     var28.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var67 = class196.getItemDefinition(var26);
                  var28.modelType = 4;
                  var28.modelId = var26;
                  var28.rotationX = var67.xan2d;
                  var28.rotationZ = var67.yan2d;
                  var28.field2320 = var67.zoom2d * 100 / var1;
                  class22.method197(var28);
               } else {
                  var28.item = var26;
                  var28.stackSize = var1;
                  var67 = class196.getItemDefinition(var26);
                  var28.rotationX = var67.xan2d;
                  var28.rotationZ = var67.yan2d;
                  var28.rotationY = var67.zan2d;
                  var28.field2268 = var67.offsetX2d;
                  var28.field2269 = var67.offsetY2d;
                  var28.field2320 = var67.zoom2d;
                  if(var67.isStackable == 1) {
                     var28.field2277 = 1;
                  } else {
                     var28.field2277 = 2;
                  }

                  if(var28.field2274 > 0) {
                     var28.field2320 = var28.field2320 * 32 / var28.field2274;
                  } else if(var28.originalWidth > 0) {
                     var28.field2320 = var28.field2320 * 32 / var28.originalWidth;
                  }

                  class22.method197(var28);
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var29;
            if(Client.packetOpcode == 30) {
               var1 = Client.secretCipherBuffer2.readInt();
               var2 = Client.secretCipherBuffer2.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var60 = FaceNormal.method1932(var1);
               } else {
                  var60 = null;
               }

               for(; Client.secretCipherBuffer2.offset < Client.field348; FaceNormal.method1931(var2, var27, var29 - 1, var6)) {
                  var27 = Client.secretCipherBuffer2.method2880();
                  var29 = Client.secretCipherBuffer2.readUnsignedShort();
                  var6 = 0;
                  if(var29 != 0) {
                     var6 = Client.secretCipherBuffer2.readUnsignedByte();
                     if(var6 == 255) {
                        var6 = Client.secretCipherBuffer2.readInt();
                     }
                  }

                  if(var60 != null && var27 >= 0 && var27 < var60.itemIds.length) {
                     var60.itemIds[var27] = var29;
                     var60.itemQuantities[var27] = var6;
                  }
               }

               if(null != var60) {
                  class22.method197(var60);
               }

               class30.method640();
               Client.interfaceItemTriggers[++Client.field492 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            long var32;
            if(Client.packetOpcode == 57) {
               var1 = Client.secretCipherBuffer2.readInt();
               var2 = Client.secretCipherBuffer2.readInt();
               if(null == class150.field2067 || !class150.field2067.isValid()) {
                  try {
                     Iterator var72 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var72.hasNext()) {
                        GarbageCollectorMXBean var91 = (GarbageCollectorMXBean)var72.next();
                        if(var91.isValid()) {
                           class150.field2067 = var91;
                           Client.field581 = -1L;
                           Client.field518 = -1L;
                        }
                     }
                  } catch (Throwable var56) {
                     ;
                  }
               }

               long var30 = class45.method867();
               var29 = -1;
               if(null != class150.field2067) {
                  var32 = class150.field2067.getCollectionTime();
                  if(-1L != Client.field518) {
                     long var34 = var32 - Client.field518;
                     var10 = var30 - Client.field581;
                     if(var10 != 0L) {
                        var29 = (int)(var34 * 100L / var10);
                     }
                  }

                  Client.field518 = var32;
                  Client.field581 = var30;
               }

               Client.secretCipherBuffer1.putOpcode(148);
               Client.secretCipherBuffer1.method2892(GameEngine.FPS);
               Client.secretCipherBuffer1.method2891(var29);
               Client.secretCipherBuffer1.method2950(var1);
               Client.secretCipherBuffer1.method2908(var2);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 139) {
               class119.field1880 = Client.secretCipherBuffer2.readUnsignedByte();
               MessageNode.field250 = Client.secretCipherBuffer2.method3051();

               for(var1 = class119.field1880; var1 < 8 + class119.field1880; ++var1) {
                  for(var2 = MessageNode.field250; var2 < 8 + MessageNode.field250; ++var2) {
                     if(Client.groundItemDeque[Sequence.plane][var1][var2] != null) {
                        Client.groundItemDeque[Sequence.plane][var1][var2] = null;
                        Client.groundItemSpawned(var1, var2);
                     }
                  }
               }

               for(class25 var82 = (class25)Client.field461.method2464(); var82 != null; var82 = (class25)Client.field461.method2472()) {
                  if(var82.field599 >= class119.field1880 && var82.field599 < 8 + class119.field1880 && var82.field597 >= MessageNode.field250 && var82.field597 < MessageNode.field250 + 8 && Sequence.plane == var82.field601) {
                     var82.field598 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 41) {
               class182.xteaChanged(true);
               Client.secretCipherBuffer2.readOpcode();
               var1 = Client.secretCipherBuffer2.readUnsignedShort();
               Actor.method572(Client.secretCipherBuffer2, var1);
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
               World var81 = new World();
               var81.address = Client.secretCipherBuffer2.readString();
               var81.id = Client.secretCipherBuffer2.readUnsignedShort();
               var2 = Client.secretCipherBuffer2.readInt();
               var81.mask = var2;
               GameObject.setGameState(45);
               class20.field233.method2113();
               class20.field233 = null;
               class142.method2750(var81);
               Client.packetOpcode = -1;
               return false;
            }

            long var37;
            WidgetNode var89;
            int var94;
            if(Client.packetOpcode == 158) {
               var1 = Client.field348 + Client.secretCipherBuffer2.offset;
               var2 = Client.secretCipherBuffer2.readUnsignedShort();
               var26 = Client.secretCipherBuffer2.readUnsignedShort();
               if(var2 != Client.widgetRoot) {
                  Client.widgetRoot = var2;
                  var27 = Client.widgetRoot;
                  var29 = class32.field755;
                  var6 = class168.field2207;
                  if(Ignore.method178(var27)) {
                     class65.method1205(Widget.widgets[var27], -1, var29, var6, false);
                  }

                  class176.method3314(Client.widgetRoot);
                  class114.method2257(Client.widgetRoot);

                  for(var27 = 0; var27 < 100; ++var27) {
                     Client.field508[var27] = true;
                  }
               }

               WidgetNode var85;
               for(; var26-- > 0; var85.field188 = true) {
                  var27 = Client.secretCipherBuffer2.readInt();
                  var29 = Client.secretCipherBuffer2.readUnsignedShort();
                  var6 = Client.secretCipherBuffer2.readUnsignedByte();
                  var85 = (WidgetNode)Client.componentTable.method2417((long)var27);
                  if(var85 != null && var85.id != var29) {
                     Item.method828(var85, true);
                     var85 = null;
                  }

                  if(null == var85) {
                     var85 = class172.method3306(var27, var29, var6);
                  }
               }

               for(var89 = (WidgetNode)Client.componentTable.method2420(); var89 != null; var89 = (WidgetNode)Client.componentTable.method2422()) {
                  if(var89.field188) {
                     var89.field188 = false;
                  } else {
                     Item.method828(var89, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.secretCipherBuffer2.offset < var1) {
                  var27 = Client.secretCipherBuffer2.readInt();
                  var29 = Client.secretCipherBuffer2.readUnsignedShort();
                  var6 = Client.secretCipherBuffer2.readUnsignedShort();
                  var94 = Client.secretCipherBuffer2.readInt();

                  for(var70 = var29; var70 <= var6; ++var70) {
                     var37 = (long)var70 + ((long)var27 << 32);
                     Client.widgetFlags.method2418(new class133(var94), var37);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 106) {
               var1 = Client.secretCipherBuffer2.method2904();
               class1.method8(var1);
               Client.interfaceItemTriggers[++Client.field492 - 1 & 31] = var1 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 95) {
               var21 = Client.secretCipherBuffer2.readString();
               Object[] var103 = new Object[var21.length() + 1];

               for(var26 = var21.length() - 1; var26 >= 0; --var26) {
                  if(var21.charAt(var26) == 115) {
                     var103[var26 + 1] = Client.secretCipherBuffer2.readString();
                  } else {
                     var103[var26 + 1] = new Integer(Client.secretCipherBuffer2.readInt());
                  }
               }

               var103[0] = new Integer(Client.secretCipherBuffer2.readInt());
               class18 var71 = new class18();
               var71.field199 = var103;
               class26.method565(var71);
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
                  DecorativeObject.cameraY = 64 + class22.field254 * 128;
                  class16.cameraZ = class103.method2025(MessageNode.cameraX, DecorativeObject.cameraY, Sequence.plane) - Ignore.field216;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 240) {
               var1 = Client.secretCipherBuffer2.method2913();
               var2 = Client.secretCipherBuffer2.readUnsignedShort();
               var26 = Client.secretCipherBuffer2.method3051();
               var89 = (WidgetNode)Client.componentTable.method2417((long)var1);
               if(null != var89) {
                  Item.method828(var89, var2 != var89.id);
               }

               class172.method3306(var1, var2, var26);
               Client.packetOpcode = -1;
               return true;
            }

            int var12;
            CipherBuffer var80;
            String var100;
            if(Client.packetOpcode == 193) {
               var80 = Client.secretCipherBuffer2;
               var2 = Client.field348;
               ClassInfo var69 = new ClassInfo();
               var69.field3240 = var80.readUnsignedByte();
               var69.field3236 = var80.readInt();
               var69.field3237 = new int[var69.field3240];
               var69.field3235 = new int[var69.field3240];
               var69.fields = new Field[var69.field3240];
               var69.field3238 = new int[var69.field3240];
               var69.methods = new Method[var69.field3240];
               var69.args = new byte[var69.field3240][][];

               for(var27 = 0; var27 < var69.field3240; ++var27) {
                  try {
                     var29 = var80.readUnsignedByte();
                     String var84;
                     String var98;
                     if(var29 != 0 && var29 != 1 && var29 != 2) {
                        if(var29 == 3 || var29 == 4) {
                           var98 = var80.readString();
                           var84 = var80.readString();
                           var70 = var80.readUnsignedByte();
                           String[] var73 = new String[var70];

                           for(var25 = 0; var25 < var70; ++var25) {
                              var73[var25] = var80.readString();
                           }

                           var100 = var80.readString();
                           byte[][] var104 = new byte[var70][];
                           int var78;
                           if(var29 == 3) {
                              for(var12 = 0; var12 < var70; ++var12) {
                                 var78 = var80.readInt();
                                 var104[var12] = new byte[var78];
                                 var80.readBytes(var104[var12], 0, var78);
                              }
                           }

                           var69.field3237[var27] = var29;
                           Class[] var106 = new Class[var70];

                           for(var78 = 0; var78 < var70; ++var78) {
                              var106[var78] = ClassInfo.method4259(var73[var78]);
                           }

                           Class var107 = ClassInfo.method4259(var100);
                           if(ClassInfo.method4259(var98).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var79 = ClassInfo.method4259(var98).getDeclaredMethods();
                           Method[] var15 = var79;

                           for(int var16 = 0; var16 < var15.length; ++var16) {
                              Method var17 = var15[var16];
                              if(Reflection.getMethodName(var17).equals(var84)) {
                                 Class[] var18 = Reflection.getParameterTypes(var17);
                                 if(var106.length == var18.length) {
                                    boolean var19 = true;

                                    for(int var20 = 0; var20 < var106.length; ++var20) {
                                       if(var106[var20] != var18[var20]) {
                                          var19 = false;
                                          break;
                                       }
                                    }

                                    if(var19 && var107 == var17.getReturnType()) {
                                       var69.methods[var27] = var17;
                                    }
                                 }
                              }
                           }

                           var69.args[var27] = var104;
                        }
                     } else {
                        var98 = var80.readString();
                        var84 = var80.readString();
                        var70 = 0;
                        if(var29 == 1) {
                           var70 = var80.readInt();
                        }

                        var69.field3237[var27] = var29;
                        var69.field3238[var27] = var70;
                        if(ClassInfo.method4259(var98).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var69.fields[var27] = Reflection.findField(ClassInfo.method4259(var98), var84);
                     }
                  } catch (ClassNotFoundException var51) {
                     var69.field3235[var27] = -1;
                  } catch (SecurityException var52) {
                     var69.field3235[var27] = -2;
                  } catch (NullPointerException var53) {
                     var69.field3235[var27] = -3;
                  } catch (Exception var54) {
                     var69.field3235[var27] = -4;
                  } catch (Throwable var55) {
                     var69.field3235[var27] = -5;
                  }
               }

               class227.field3244.method2430(var69);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 214) {
               var1 = Client.secretCipherBuffer2.readUnsignedShort();
               var2 = Client.secretCipherBuffer2.readUnsignedByte();
               var26 = Client.secretCipherBuffer2.readUnsignedShort();
               if(Client.field543 != 0 && var2 != 0 && Client.field545 < 50) {
                  Client.field546[Client.field545] = var1;
                  Client.field547[Client.field545] = var2;
                  Client.field334[Client.field545] = var26;
                  Client.field550[Client.field545] = null;
                  Client.field464[Client.field545] = 0;
                  ++Client.field545;
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var76;
            boolean var87;
            if(Client.packetOpcode == 232) {
               var1 = Client.secretCipherBuffer2.method2880();
               var76 = Client.secretCipherBuffer2.readUnsignedByte() == 1;
               var3 = "";
               var87 = false;
               if(var76) {
                  var3 = Client.secretCipherBuffer2.readString();
                  if(class94.method1951(var3)) {
                     var87 = true;
                  }
               }

               String var66 = Client.secretCipherBuffer2.readString();
               if(!var87) {
                  Player.sendGameMessage(var1, var3, var66);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 207) {
               var1 = Client.secretCipherBuffer2.readUnsignedByte();
               if(Client.secretCipherBuffer2.readUnsignedByte() == 0) {
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  Client.secretCipherBuffer2.offset += 18;
               } else {
                  --Client.secretCipherBuffer2.offset;
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer(Client.secretCipherBuffer2, false);
               }

               Client.field498 = Client.field561;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 204) {
               var59 = Client.secretCipherBuffer2.readUnsignedByte() == 1;
               if(var59) {
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
                  var80 = Client.secretCipherBuffer2;
                  var2 = Client.secretCipherBuffer2.offset - 28;
                  class181.method3332(var80.payload, var2);
                  if(null != class104.field1712) {
                     try {
                        class104.field1712.method1437(0L);
                        class104.field1712.method1443(var80.payload, var2, 24);
                     } catch (Exception var50) {
                        ;
                     }
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 190) {
               Client.field446 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  Client.field552[var1] = false;
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
               var1 = Client.secretCipherBuffer2.method2853();
               var2 = Client.secretCipherBuffer2.readInt();
               var60 = FaceNormal.method1932(var2);
               if(null != var60 && var60.type == 0) {
                  if(var1 > var60.scrollHeight - var60.height) {
                     var1 = var60.scrollHeight - var60.height;
                  }

                  if(var1 < 0) {
                     var1 = 0;
                  }

                  if(var1 != var60.scrollY) {
                     var60.scrollY = var1;
                     class22.method197(var60);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 113) {
               var21 = Client.secretCipherBuffer2.readString();
               var2 = Client.secretCipherBuffer2.readUnsignedShort();
               byte var92 = Client.secretCipherBuffer2.readByte();
               var87 = false;
               if(var92 == -128) {
                  var87 = true;
               }

               if(var87) {
                  if(VertexNormal.clanChatCount == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  boolean var93 = false;

                  for(var29 = 0; var29 < VertexNormal.clanChatCount && (!class156.clanMembers[var29].username.equals(var21) || var2 != class156.clanMembers[var29].world); ++var29) {
                     ;
                  }

                  if(var29 < VertexNormal.clanChatCount) {
                     while(var29 < VertexNormal.clanChatCount - 1) {
                        class156.clanMembers[var29] = class156.clanMembers[var29 + 1];
                        ++var29;
                     }

                     --VertexNormal.clanChatCount;
                     class156.clanMembers[VertexNormal.clanChatCount] = null;
                  }
               } else {
                  Client.secretCipherBuffer2.readString();
                  XClanMember var65 = new XClanMember();
                  var65.username = var21;
                  var65.field291 = class187.method3483(var65.username, Ignore.field214);
                  var65.world = var2;
                  var65.rank = var92;

                  for(var6 = VertexNormal.clanChatCount - 1; var6 >= 0; --var6) {
                     var94 = class156.clanMembers[var6].field291.compareTo(var65.field291);
                     if(var94 == 0) {
                        class156.clanMembers[var6].world = var2;
                        class156.clanMembers[var6].rank = var92;
                        if(var21.equals(Projectile.localPlayer.name)) {
                           class9.field75 = var92;
                        }

                        Client.field497 = Client.field561;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var94 < 0) {
                        break;
                     }
                  }

                  if(VertexNormal.clanChatCount >= class156.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var94 = VertexNormal.clanChatCount - 1; var94 > var6; --var94) {
                     class156.clanMembers[var94 + 1] = class156.clanMembers[var94];
                  }

                  if(VertexNormal.clanChatCount == 0) {
                     class156.clanMembers = new XClanMember[100];
                  }

                  class156.clanMembers[var6 + 1] = var65;
                  ++VertexNormal.clanChatCount;
                  if(var21.equals(Projectile.localPlayer.name)) {
                     class9.field75 = var92;
                  }
               }

               Client.field497 = Client.field561;
               Client.packetOpcode = -1;
               return true;
            }

            String var90;
            if(Client.packetOpcode == 161) {
               while(Client.secretCipherBuffer2.offset < Client.field348) {
                  var1 = Client.secretCipherBuffer2.readUnsignedByte();
                  var76 = (var1 & 1) == 1;
                  var3 = Client.secretCipherBuffer2.readString();
                  var90 = Client.secretCipherBuffer2.readString();
                  Client.secretCipherBuffer2.readString();

                  for(var29 = 0; var29 < Client.ignoreCount; ++var29) {
                     Ignore var97 = Client.ignores[var29];
                     if(var76) {
                        if(var90.equals(var97.name)) {
                           var97.name = var3;
                           var97.previousName = var90;
                           var3 = null;
                           break;
                        }
                     } else if(var3.equals(var97.name)) {
                        var97.name = var3;
                        var97.previousName = var90;
                        var3 = null;
                        break;
                     }
                  }

                  if(var3 != null && Client.ignoreCount < 400) {
                     Ignore var64 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var64;
                     var64.name = var3;
                     var64.previousName = var90;
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

               for(var1 = 0; var1 < 2048; ++var1) {
                  Client.cachedPlayers[var1] = null;
               }

               RSSocket.method2100(Client.secretCipherBuffer2);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 55) {
               var1 = Client.secretCipherBuffer2.readInt();
               var2 = Client.secretCipherBuffer2.method2853();
               var60 = FaceNormal.method1932(var1);
               if(var60.modelType != 2 || var2 != var60.modelId) {
                  var60.modelType = 2;
                  var60.modelId = var2;
                  class22.method197(var60);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 91) {
               var1 = Client.secretCipherBuffer2.method2903();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               if(var1 == -1 && !Client.field542) {
                  TextureProvider.method1486();
               } else if(var1 != -1 && var1 != Client.field541 && Client.field540 != 0 && !Client.field542) {
                  IndexData var102 = Client.field586;
                  var26 = Client.field540;
                  class138.field1940 = 1;
                  class149.field2061 = var102;
                  class138.field1941 = var1;
                  RSCanvas.field1777 = 0;
                  NPC.field783 = var26;
                  class138.field1938 = false;
                  class138.field1937 = 2;
               }

               Client.field541 = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 164) {
               var1 = Client.secretCipherBuffer2.method2851();
               var2 = Client.secretCipherBuffer2.readUnsignedShort();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(Client.field540 != 0 && var2 != -1) {
                  TextureProvider.method1487(Friend.field162, var2, 0, Client.field540, false);
                  Client.field542 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 176) {
               for(var1 = 0; var1 < class187.field2789; ++var1) {
                  class187 var101 = class109.method2096(var1);
                  if(var101 != null) {
                     class165.settings[var1] = 0;
                     class165.widgetSettings[var1] = 0;
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

            Widget var95;
            if(Client.packetOpcode == 215) {
               var1 = Client.secretCipherBuffer2.method2912();
               var95 = FaceNormal.method1932(var1);
               var95.modelType = 3;
               var95.modelId = Projectile.localPlayer.composition.method3208();
               class22.method197(var95);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 159) {
               var1 = Client.secretCipherBuffer2.method2903();
               var2 = Client.secretCipherBuffer2.method2913();
               var26 = var1 >> 10 & 31;
               var27 = var1 >> 5 & 31;
               var29 = var1 & 31;
               var6 = (var26 << 19) + (var27 << 11) + (var29 << 3);
               Widget var83 = FaceNormal.method1932(var2);
               if(var6 != var83.textColor) {
                  var83.textColor = var6;
                  class22.method197(var83);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 135) {
               class182.xteaChanged(false);
               Client.secretCipherBuffer2.readOpcode();
               var1 = Client.secretCipherBuffer2.readUnsignedShort();
               Actor.method572(Client.secretCipherBuffer2, var1);
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
               var1 = Client.secretCipherBuffer2.readInt();
               WidgetNode var99 = (WidgetNode)Client.componentTable.method2417((long)var1);
               if(null != var99) {
                  Item.method828(var99, true);
               }

               if(null != Client.field467) {
                  class22.method197(Client.field467);
                  Client.field467 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 126) {
               class30.method640();
               var1 = Client.secretCipherBuffer2.method3051();
               var2 = Client.secretCipherBuffer2.method2912();
               var26 = Client.secretCipherBuffer2.method3051();
               Client.skillExperiences[var26] = var2;
               Client.boostedSkillLevels[var26] = var1;
               Client.realSkillLevels[var26] = 1;

               for(var27 = 0; var27 < 98; ++var27) {
                  if(var2 >= class172.field2369[var27]) {
                     Client.realSkillLevels[var26] = 2 + var27;
                  }
               }

               Client.field493[++Client.field503 - 1 & 31] = var26;
               Client.packetOpcode = -1;
               return true;
            }

            String var39;
            if(Client.packetOpcode == 62) {
               var21 = Client.secretCipherBuffer2.readString();
               CipherBuffer var62 = Client.secretCipherBuffer2;
               var39 = IndexFile.method2305(var62, 32767);
               var90 = FontTypeFace.method3900(class94.method1954(var39));
               Player.sendGameMessage(6, var21, var90);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 134) {
               byte var68 = Client.secretCipherBuffer2.readByte();
               var2 = Client.secretCipherBuffer2.method2853();
               class165.settings[var2] = var68;
               if(class165.widgetSettings[var2] != var68) {
                  class165.widgetSettings[var2] = var68;
               }

               Client.method550(var2);
               Client.field489[++Client.field490 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 236) {
               var1 = Client.secretCipherBuffer2.readInt();
               var95 = FaceNormal.method1932(var1);

               for(var26 = 0; var26 < var95.itemIds.length; ++var26) {
                  var95.itemIds[var26] = -1;
                  var95.itemIds[var26] = 0;
               }

               class22.method197(var95);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 250) {
               class72.method1444(Client.secretCipherBuffer2.readString());
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 99) {
               var1 = Client.secretCipherBuffer2.readInt();
               var2 = Client.secretCipherBuffer2.method2939();
               var26 = Client.secretCipherBuffer2.readShort();
               var28 = FaceNormal.method1932(var1);
               if(var28.originalX != var2 || var28.originalY != var26 || var28.field2351 != 0 || var28.field2217 != 0) {
                  var28.originalX = var2;
                  var28.originalY = var26;
                  var28.field2351 = 0;
                  var28.field2217 = 0;
                  class22.method197(var28);
                  XGrandExchangeOffer.method54(var28);
                  if(var28.type == 0) {
                     class2.method16(Widget.widgets[var1 >> 16], var28, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            String var43;
            long var45;
            if(Client.packetOpcode == 86) {
               var21 = Client.secretCipherBuffer2.readString();
               var45 = (long)Client.secretCipherBuffer2.readUnsignedShort();
               var4 = (long)Client.secretCipherBuffer2.read24BitInt();
               class177 var96 = (class177)Client.method556(class3.method23(), Client.secretCipherBuffer2.readUnsignedByte());
               var7 = var4 + (var45 << 32);
               boolean var108 = false;

               for(var25 = 0; var25 < 100; ++var25) {
                  if(Client.field524[var25] == var7) {
                     var108 = true;
                     break;
                  }
               }

               if(class94.method1951(var21)) {
                  var108 = true;
               }

               if(!var108 && Client.field421 == 0) {
                  Client.field524[Client.field525] = var7;
                  Client.field525 = (Client.field525 + 1) % 100;
                  CipherBuffer var42 = Client.secretCipherBuffer2;
                  var100 = IndexFile.method2305(var42, 32767);
                  var43 = FontTypeFace.method3900(class94.method1954(var100));
                  byte var13;
                  if(var96.field2690) {
                     var13 = 7;
                  } else {
                     var13 = 3;
                  }

                  if(var96.field2695 != -1) {
                     Player.sendGameMessage(var13, class30.method648(var96.field2695) + var21, var43);
                  } else {
                     Player.sendGameMessage(var13, var21, var43);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 69) {
               for(var1 = 0; var1 < Client.cachedPlayers.length; ++var1) {
                  if(null != Client.cachedPlayers[var1]) {
                     Client.cachedPlayers[var1].animation = -1;
                  }
               }

               for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                  if(null != Client.cachedNPCs[var1]) {
                     Client.cachedNPCs[var1].animation = -1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 35) {
               var1 = Client.secretCipherBuffer2.readUnsignedByte();
               var2 = Client.secretCipherBuffer2.readUnsignedByte();
               var26 = Client.secretCipherBuffer2.readUnsignedByte();
               var27 = Client.secretCipherBuffer2.readUnsignedByte();
               Client.field552[var1] = true;
               Client.field482[var1] = var2;
               Client.field356[var1] = var26;
               Client.field383[var1] = var27;
               Client.field413[var1] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 233) {
               for(var1 = 0; var1 < class165.widgetSettings.length; ++var1) {
                  if(class165.settings[var1] != class165.widgetSettings[var1]) {
                     class165.widgetSettings[var1] = class165.settings[var1];
                     Client.method550(var1);
                     Client.field489[++Client.field490 - 1 & 31] = var1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 20) {
               var1 = Client.secretCipherBuffer2.method2939();
               var2 = Client.secretCipherBuffer2.method3006();
               var60 = FaceNormal.method1932(var2);
               if(var60.field2266 != var1 || var1 == -1) {
                  var60.field2266 = var1;
                  var60.field2344 = 0;
                  var60.field2342 = 0;
                  class22.method197(var60);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 221) {
               var1 = Client.secretCipherBuffer2.method2853();
               Client.widgetRoot = var1;
               var2 = Client.widgetRoot;
               var26 = class32.field755;
               var27 = class168.field2207;
               if(Ignore.method178(var2)) {
                  class65.method1205(Widget.widgets[var2], -1, var26, var27, false);
               }

               class176.method3314(var1);
               class114.method2257(Client.widgetRoot);

               for(var2 = 0; var2 < 100; ++var2) {
                  Client.field508[var2] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 242) {
               var1 = Client.secretCipherBuffer2.method3006();
               var2 = Client.secretCipherBuffer2.readInt();
               var26 = Client.secretCipherBuffer2.method2853();
               if(var26 == '\uffff') {
                  var26 = -1;
               }

               var27 = Client.secretCipherBuffer2.method2853();
               if(var27 == '\uffff') {
                  var27 = -1;
               }

               for(var29 = var27; var29 <= var26; ++var29) {
                  var32 = (long)var29 + ((long)var2 << 32);
                  Node var109 = Client.widgetFlags.method2417(var32);
                  if(null != var109) {
                     var109.unlink();
                  }

                  Client.widgetFlags.method2418(new class133(var1), var32);
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
                  var1 = IndexFile.field1839 * 128 + 64;
                  var2 = 64 + Projectile.field900 * 128;
                  var26 = class103.method2025(var1, var2, Sequence.plane) - class145.field2033;
                  var27 = var1 - MessageNode.cameraX;
                  var29 = var26 - class16.cameraZ;
                  var6 = var2 - DecorativeObject.cameraY;
                  var94 = (int)Math.sqrt((double)(var27 * var27 + var6 * var6));
                  class16.cameraPitch = (int)(Math.atan2((double)var29, (double)var94) * 325.949D) & 2047;
                  class9.cameraYaw = (int)(Math.atan2((double)var27, (double)var6) * -325.949D) & 2047;
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
               var1 = Client.secretCipherBuffer2.method3006();
               var2 = Client.secretCipherBuffer2.readInt();
               WidgetNode var61 = (WidgetNode)Client.componentTable.method2417((long)var2);
               var89 = (WidgetNode)Client.componentTable.method2417((long)var1);
               if(var89 != null) {
                  Item.method828(var89, var61 == null || var61.id != var89.id);
               }

               if(var61 != null) {
                  var61.unlink();
                  Client.componentTable.method2418(var61, (long)var1);
               }

               var63 = FaceNormal.method1932(var2);
               if(null != var63) {
                  class22.method197(var63);
               }

               var63 = FaceNormal.method1932(var1);
               if(null != var63) {
                  class22.method197(var63);
                  class2.method16(Widget.widgets[var63.id >>> 16], var63, true);
               }

               if(Client.widgetRoot != -1) {
                  class33.method718(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 56) {
               var1 = Client.secretCipherBuffer2.readInt();
               var2 = Client.secretCipherBuffer2.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var60 = FaceNormal.method1932(var1);
               } else {
                  var60 = null;
               }

               if(var60 != null) {
                  for(var27 = 0; var27 < var60.itemIds.length; ++var27) {
                     var60.itemIds[var27] = 0;
                     var60.itemQuantities[var27] = 0;
                  }
               }

               XItemContainer var88 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var2);
               if(var88 != null) {
                  for(var29 = 0; var29 < var88.itemIds.length; ++var29) {
                     var88.itemIds[var29] = -1;
                     var88.stackSizes[var29] = 0;
                  }
               }

               var27 = Client.secretCipherBuffer2.readUnsignedShort();

               for(var29 = 0; var29 < var27; ++var29) {
                  var6 = Client.secretCipherBuffer2.method3015();
                  if(var6 == 255) {
                     var6 = Client.secretCipherBuffer2.method2913();
                  }

                  var94 = Client.secretCipherBuffer2.method2903();
                  if(null != var60 && var29 < var60.itemIds.length) {
                     var60.itemIds[var29] = var94;
                     var60.itemQuantities[var29] = var6;
                  }

                  FaceNormal.method1931(var2, var29, var94 - 1, var6);
               }

               if(null != var60) {
                  class22.method197(var60);
               }

               class30.method640();
               Client.interfaceItemTriggers[++Client.field492 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var11;
            if(Client.packetOpcode == 198) {
               while(Client.secretCipherBuffer2.offset < Client.field348) {
                  var59 = Client.secretCipherBuffer2.readUnsignedByte() == 1;
                  var39 = Client.secretCipherBuffer2.readString();
                  var3 = Client.secretCipherBuffer2.readString();
                  var27 = Client.secretCipherBuffer2.readUnsignedShort();
                  var29 = Client.secretCipherBuffer2.readUnsignedByte();
                  var6 = Client.secretCipherBuffer2.readUnsignedByte();
                  boolean var36 = (var6 & 2) != 0;
                  var8 = (var6 & 1) != 0;
                  if(var27 > 0) {
                     Client.secretCipherBuffer2.readString();
                     Client.secretCipherBuffer2.readUnsignedByte();
                     Client.secretCipherBuffer2.readInt();
                  }

                  Client.secretCipherBuffer2.readString();

                  for(int var47 = 0; var47 < Client.friendCount; ++var47) {
                     Friend var41 = Client.friends[var47];
                     if(!var59) {
                        if(var39.equals(var41.name)) {
                           if(var41.world != var27) {
                              var11 = true;

                              for(class16 var105 = (class16)Client.field531.method2499(); null != var105; var105 = (class16)Client.field531.method2500()) {
                                 if(var105.field178.equals(var39)) {
                                    if(var27 != 0 && var105.field182 == 0) {
                                       var105.method2511();
                                       var11 = false;
                                    } else if(var27 == 0 && var105.field182 != 0) {
                                       var105.method2511();
                                       var11 = false;
                                    }
                                 }
                              }

                              if(var11) {
                                 Client.field531.method2498(new class16(var39, var27));
                              }

                              var41.world = var27;
                           }

                           var41.previousName = var3;
                           var41.rank = var29;
                           var41.field157 = var36;
                           var41.field156 = var8;
                           var39 = null;
                           break;
                        }
                     } else if(var3.equals(var41.name)) {
                        var41.name = var39;
                        var41.previousName = var3;
                        var39 = null;
                        break;
                     }
                  }

                  if(null != var39 && Client.friendCount < 400) {
                     Friend var9 = new Friend();
                     Client.friends[Client.friendCount] = var9;
                     var9.name = var39;
                     var9.previousName = var3;
                     var9.world = var27;
                     var9.rank = var29;
                     var9.field157 = var36;
                     var9.field156 = var8;
                     ++Client.friendCount;
                  }
               }

               Client.field571 = 2;
               Client.field496 = Client.field561;
               var59 = false;
               var2 = Client.friendCount;

               while(var2 > 0) {
                  var59 = true;
                  --var2;

                  for(var26 = 0; var26 < var2; ++var26) {
                     var87 = false;
                     Friend var5 = Client.friends[var26];
                     Friend var40 = Client.friends[1 + var26];
                     if(var5.world != Client.world && Client.world == var40.world) {
                        var87 = true;
                     }

                     if(!var87 && var5.world == 0 && var40.world != 0) {
                        var87 = true;
                     }

                     if(!var87 && !var5.field157 && var40.field157) {
                        var87 = true;
                     }

                     if(!var87 && !var5.field156 && var40.field156) {
                        var87 = true;
                     }

                     if(var87) {
                        Friend var24 = Client.friends[var26];
                        Client.friends[var26] = Client.friends[var26 + 1];
                        Client.friends[var26 + 1] = var24;
                        var59 = false;
                     }
                  }

                  if(var59) {
                     break;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 206) {
               var1 = Client.secretCipherBuffer2.readUnsignedShort();
               var2 = Client.secretCipherBuffer2.readInt();
               var26 = Client.secretCipherBuffer2.method2903();
               var28 = FaceNormal.method1932(var2);
               var28.field2275 = var26 + (var1 << 16);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 63) {
               var21 = Client.secretCipherBuffer2.readString();
               var45 = Client.secretCipherBuffer2.readLong();
               var4 = (long)Client.secretCipherBuffer2.readUnsignedShort();
               var32 = (long)Client.secretCipherBuffer2.read24BitInt();
               class177 var48 = (class177)Client.method556(class3.method23(), Client.secretCipherBuffer2.readUnsignedByte());
               var37 = var32 + (var4 << 32);
               var11 = false;

               for(var12 = 0; var12 < 100; ++var12) {
                  if(var37 == Client.field524[var12]) {
                     var11 = true;
                     break;
                  }
               }

               if(var48.field2688 && class94.method1951(var21)) {
                  var11 = true;
               }

               if(!var11 && Client.field421 == 0) {
                  Client.field524[Client.field525] = var37;
                  Client.field525 = (Client.field525 + 1) % 100;
                  CipherBuffer var44 = Client.secretCipherBuffer2;
                  var43 = IndexFile.method2305(var44, 32767);
                  String var14 = FontTypeFace.method3900(class94.method1954(var43));
                  if(var48.field2695 != -1) {
                     class216.addChatMessage(9, class30.method648(var48.field2695) + var21, var14, class7.method80(var45));
                  } else {
                     class216.addChatMessage(9, var21, var14, class7.method80(var45));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 174) {
               var1 = Client.secretCipherBuffer2.method2913();
               class36.field795 = class108.field1755.method2011(var1);
               Client.packetOpcode = -1;
               return true;
            }

            GameObject.method1958("" + Client.packetOpcode + "," + Client.field424 + "," + Client.field354 + "," + Client.field348, (Throwable)null);
            WallObject.method1930();
         } catch (IOException var57) {
            class107.method2083();
         } catch (Exception var58) {
            var21 = "" + Client.packetOpcode + "," + Client.field424 + "," + Client.field354 + "," + Client.field348 + "," + (class119.baseX + Projectile.localPlayer.pathX[0]) + "," + (class187.baseY + Projectile.localPlayer.pathY[0]) + ",";

            for(var2 = 0; var2 < Client.field348 && var2 < 50; ++var2) {
               var21 = var21 + Client.secretCipherBuffer2.payload[var2] + ",";
            }

            GameObject.method1958(var21, var58);
            WallObject.method1930();
         }

         return true;
      }
   }
}
