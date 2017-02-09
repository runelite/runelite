import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("by")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("y")
   Deque field1200 = new Deque();
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1142594337
   )
   int field1201;
   @ObfuscatedName("k")
   class79[] field1202;
   @ObfuscatedName("w")
   double field1203 = 1.0D;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -8917589
   )
   int field1204 = 0;
   @ObfuscatedName("q")
   class182 field1205;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1131832107
   )
   int field1207 = 128;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1440(double var1) {
      this.field1203 = var1;
      this.method1445();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "2003417490"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1202[var1];
      if(var2 != null) {
         if(var2.field1313 != null) {
            this.field1200.method2381(var2);
            var2.field1308 = true;
            return var2.field1313;
         }

         boolean var3 = var2.method1556(this.field1203, this.field1207, this.field1205);
         if(var3) {
            if(this.field1204 == 0) {
               class79 var4 = (class79)this.field1200.method2384();
               var4.method1550();
            } else {
               --this.field1204;
            }

            this.field1200.method2381(var2);
            var2.field1308 = true;
            return var2.field1313;
         }
      }

      return null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-390751284"
   )
   public int vmethod1888(int var1) {
      return null != this.field1202[var1]?this.field1202[var1].field1304:0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-14"
   )
   public boolean vmethod1891(int var1) {
      return this.field1207 == 64;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-626661619"
   )
   public void method1445() {
      for(int var1 = 0; var1 < this.field1202.length; ++var1) {
         if(null != this.field1202[var1]) {
            this.field1202[var1].method1550();
         }
      }

      this.field1200 = new Deque();
      this.field1204 = this.field1201;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-41"
   )
   public void method1446(int var1) {
      for(int var2 = 0; var2 < this.field1202.length; ++var2) {
         class79 var3 = this.field1202[var2];
         if(null != var3 && var3.field1311 != 0 && var3.field1308) {
            var3.method1551(var1);
            var3.field1308 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class182 var1, class182 var2, int var3, double var4, int var6) {
      this.field1205 = var2;
      this.field1201 = var3;
      this.field1204 = this.field1201;
      this.field1203 = var4;
      this.field1207 = var6;
      int[] var7 = var1.method3282(0);
      int var8 = var7.length;
      this.field1202 = new class79[var1.method3283(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1202[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "842871084"
   )
   public boolean vmethod1895(int var1) {
      return this.field1202[var1].field1306;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "1268083344"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3049.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3045.getConfigData(12, var0);
         var1 = new Sequence();
         if(null != var2) {
            var1.method3780(new Buffer(var2));
         }

         var1.method3756();
         Sequence.field3049.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "-367829085"
   )
   static void method1460(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(null != var6 && var1 == var6.parentId) {
            class38.method760(var6, var2, var3, var4);
            class7.method109(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class22.method233(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Ljava/lang/String;",
      garbageValue = "-1782757622"
   )
   static String method1461(Widget var0) {
      int var2 = class88.method1872(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.field2128 != null && var0.field2128.trim().length() != 0?var0.field2128:null);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "576581392"
   )
   static final boolean method1462() {
      if(class177.field2657 == null) {
         return false;
      } else {
         int var2;
         String var24;
         try {
            int var0 = class177.field2657.method2052();
            if(var0 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               class177.field2657.method2053(Client.field323.payload, 0, 1);
               Client.field323.offset = 0;
               Client.packetOpcode = Client.field323.method3190();
               Client.field324 = class212.field3120[Client.packetOpcode];
               --var0;
            }

            if(Client.field324 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class177.field2657.method2053(Client.field323.payload, 0, 1);
               Client.field324 = Client.field323.payload[0] & 255;
               --var0;
            }

            if(Client.field324 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class177.field2657.method2053(Client.field323.payload, 0, 2);
               Client.field323.offset = 0;
               Client.field324 = Client.field323.readUnsignedShort();
               var0 -= 2;
            }

            if(var0 < Client.field324) {
               return false;
            }

            Client.field323.offset = 0;
            class177.field2657.method2053(Client.field323.payload, 0, Client.field324);
            Client.field326 = 0;
            Client.field330 = Client.field329;
            Client.field329 = Client.field284 * -1;
            Client.field284 = Client.packetOpcode * -1;
            int var1;
            if(Client.packetOpcode == 90) {
               for(var1 = 0; var1 < class146.widgetSettings.length; ++var1) {
                  if(class146.settings[var1] != class146.widgetSettings[var1]) {
                     class146.widgetSettings[var1] = class146.settings[var1];
                     class182.method3296(var1);
                     Client.field393[++Client.field561 - 1 & 31] = var1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var3;
            int var4;
            if(Client.packetOpcode == 30) {
               Actor.method642();
               var1 = Client.field323.readUnsignedByte();
               var2 = Client.field323.method2953();
               var3 = Client.field323.method2974();
               Client.skillExperiences[var2] = var3;
               Client.boostedSkillLevels[var2] = var1;
               Client.realSkillLevels[var2] = 1;

               for(var4 = 0; var4 < 98; ++var4) {
                  if(var3 >= class172.field2334[var4]) {
                     Client.realSkillLevels[var2] = var4 + 2;
                  }
               }

               Client.field448[++Client.field468 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 252) {
               class114.method2188();
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 207) {
               Friend.field153 = Client.field323.method2954();
               class18.field199 = Client.field323.method3092();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 155) {
               Client.field333 = 1;
               Client.field470 = Client.field462;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 197 || Client.packetOpcode == 115 || Client.packetOpcode == 194 || Client.packetOpcode == 160 || Client.packetOpcode == 77 || Client.packetOpcode == 82 || Client.packetOpcode == 165 || Client.packetOpcode == 234 || Client.packetOpcode == 141 || Client.packetOpcode == 136) {
               class38.method764();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 12) {
               byte var92 = Client.field323.method2956();
               var2 = Client.field323.readUnsignedShort();
               class146.settings[var2] = var92;
               if(var92 != class146.widgetSettings[var2]) {
                  class146.widgetSettings[var2] = var92;
               }

               class182.method3296(var2);
               Client.field393[++Client.field561 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            Widget var89;
            if(Client.packetOpcode == 224) {
               var1 = Client.field323.readUnsignedShort();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = Client.field323.method3062();
               var3 = Client.field323.method3062();
               var89 = class37.method759(var2);
               ItemComposition var74;
               if(!var89.hasScript) {
                  if(var1 == -1) {
                     var89.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var74 = PlayerComposition.getItemDefinition(var1);
                  var89.modelType = 4;
                  var89.modelId = var1;
                  var89.rotationX = var74.xan2d;
                  var89.rotationZ = var74.yan2d;
                  var89.field2103 = var74.zoom2d * 100 / var3;
                  class2.method28(var89);
               } else {
                  var89.item = var1;
                  var89.stackSize = var3;
                  var74 = PlayerComposition.getItemDefinition(var1);
                  var89.rotationX = var74.xan2d;
                  var89.rotationZ = var74.yan2d;
                  var89.rotationY = var74.zan2d;
                  var89.field2160 = var74.offsetX2d;
                  var89.field2114 = var74.offsetY2d;
                  var89.field2103 = var74.zoom2d;
                  if(var74.isStackable == 1) {
                     var89.field2057 = 1;
                  } else {
                     var89.field2057 = 2;
                  }

                  if(var89.field2104 > 0) {
                     var89.field2103 = var89.field2103 * 32 / var89.field2104;
                  } else if(var89.originalWidth > 0) {
                     var89.field2103 = var89.field2103 * 32 / var89.originalWidth;
                  }

                  class2.method28(var89);
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var22;
            boolean var69;
            if(Client.packetOpcode == 240) {
               var69 = Client.field323.method3092() == 1;
               var2 = Client.field323.method2972();
               var22 = class37.method759(var2);
               if(var22.isHidden != var69) {
                  var22.isHidden = var69;
                  class2.method28(var22);
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var6;
            int var23;
            if(Client.packetOpcode == 73) {
               var1 = Client.field323.method3062();
               var2 = Client.field323.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var22 = class37.method759(var1);
               } else {
                  var22 = null;
               }

               for(; Client.field323.offset < Client.field324; class6.method94(var2, var4, var23 - 1, var6)) {
                  var4 = Client.field323.method2939();
                  var23 = Client.field323.readUnsignedShort();
                  var6 = 0;
                  if(var23 != 0) {
                     var6 = Client.field323.readUnsignedByte();
                     if(var6 == 255) {
                        var6 = Client.field323.method3062();
                     }
                  }

                  if(var22 != null && var4 >= 0 && var4 < var22.itemIds.length) {
                     var22.itemIds[var4] = var23;
                     var22.itemQuantities[var4] = var6;
                  }
               }

               if(null != var22) {
                  class2.method28(var22);
               }

               Actor.method642();
               Client.interfaceItemTriggers[++Client.field466 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 232) {
               var1 = Client.field323.readUnsignedByte();
               var2 = Client.field323.readUnsignedByte();
               var3 = Client.field323.readUnsignedByte();
               var4 = Client.field323.readUnsignedByte();
               Client.field527[var1] = true;
               Client.field528[var1] = var2;
               Client.field529[var1] = var3;
               Client.field387[var1] = var4;
               Client.field531[var1] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            int var7;
            boolean var68;
            boolean var103;
            if(Client.packetOpcode == 99) {
               var24 = Client.field323.method2934();
               var2 = Client.field323.readUnsignedShort();
               byte var77 = Client.field323.readByte();
               var68 = false;
               if(var77 == -128) {
                  var68 = true;
               }

               if(var68) {
                  if(class72.clanChatCount == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var103 = false;

                  for(var23 = 0; var23 < class72.clanChatCount && (!class85.clanMembers[var23].username.equals(var24) || class85.clanMembers[var23].world != var2); ++var23) {
                     ;
                  }

                  if(var23 < class72.clanChatCount) {
                     while(var23 < class72.clanChatCount - 1) {
                        class85.clanMembers[var23] = class85.clanMembers[1 + var23];
                        ++var23;
                     }

                     --class72.clanChatCount;
                     class85.clanMembers[class72.clanChatCount] = null;
                  }
               } else {
                  Client.field323.method2934();
                  XClanMember var73 = new XClanMember();
                  var73.username = var24;
                  var73.field268 = Overlay.method3751(var73.username, Client.field282);
                  var73.world = var2;
                  var73.rank = var77;

                  for(var6 = class72.clanChatCount - 1; var6 >= 0; --var6) {
                     var7 = class85.clanMembers[var6].field268.compareTo(var73.field268);
                     if(var7 == 0) {
                        class85.clanMembers[var6].world = var2;
                        class85.clanMembers[var6].rank = var77;
                        if(var24.equals(VertexNormal.localPlayer.name)) {
                           Buffer.field2265 = var77;
                        }

                        Client.field471 = Client.field462;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var7 < 0) {
                        break;
                     }
                  }

                  if(class72.clanChatCount >= class85.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var7 = class72.clanChatCount - 1; var7 > var6; --var7) {
                     class85.clanMembers[1 + var7] = class85.clanMembers[var7];
                  }

                  if(class72.clanChatCount == 0) {
                     class85.clanMembers = new XClanMember[100];
                  }

                  class85.clanMembers[1 + var6] = var73;
                  ++class72.clanChatCount;
                  if(var24.equals(VertexNormal.localPlayer.name)) {
                     Buffer.field2265 = var77;
                  }
               }

               Client.field471 = Client.field462;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 196) {
               class38.method762(Client.field323, Client.field324);
               Client.packetOpcode = -1;
               return true;
            }

            Widget var71;
            WidgetNode var90;
            if(Client.packetOpcode == 128) {
               var1 = Client.field323.method2972();
               var2 = Client.field323.method2972();
               WidgetNode var107 = (WidgetNode)Client.componentTable.method2331((long)var2);
               var90 = (WidgetNode)Client.componentTable.method2331((long)var1);
               if(null != var90) {
                  class39.method768(var90, var107 == null || var90.id != var107.id);
               }

               if(null != var107) {
                  var107.unlink();
                  Client.componentTable.method2333(var107, (long)var1);
               }

               var71 = class37.method759(var2);
               if(var71 != null) {
                  class2.method28(var71);
               }

               var71 = class37.method759(var1);
               if(null != var71) {
                  class2.method28(var71);
                  class22.method233(Widget.widgets[var71.id >>> 16], var71, true);
               }

               if(Client.widgetRoot != -1) {
                  class148.method2769(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 92) {
               Client.field526 = true;
               Item.field891 = Client.field323.readUnsignedByte();
               VertexNormal.field1422 = Client.field323.readUnsignedByte();
               Varbit.field2835 = Client.field323.readUnsignedShort();
               class162.field2282 = Client.field323.readUnsignedByte();
               class22.field240 = Client.field323.readUnsignedByte();
               if(class22.field240 >= 100) {
                  class202.cameraX = 64 + Item.field891 * 128;
                  class16.cameraY = VertexNormal.field1422 * 128 + 64;
                  class32.cameraZ = Renderable.method1883(class202.cameraX, class16.cameraY, class48.plane) - Varbit.field2835;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 67) {
               var1 = Client.field323.readShort();
               var2 = Client.field323.method2972();
               var22 = class37.method759(var2);
               if(var1 != var22.field2164 || var1 == -1) {
                  var22.field2164 = var1;
                  var22.field2054 = 0;
                  var22.field2176 = 0;
                  class2.method28(var22);
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var67;
            String var91;
            String var93;
            if(Client.packetOpcode == 97) {
               while(Client.field323.offset < Client.field324) {
                  var1 = Client.field323.readUnsignedByte();
                  var67 = (var1 & 1) == 1;
                  var91 = Client.field323.method2934();
                  var93 = Client.field323.method2934();
                  Client.field323.method2934();

                  for(var23 = 0; var23 < Client.ignoreCount; ++var23) {
                     Ignore var105 = Client.ignores[var23];
                     if(var67) {
                        if(var93.equals(var105.name)) {
                           var105.name = var91;
                           var105.previousName = var93;
                           var91 = null;
                           break;
                        }
                     } else if(var91.equals(var105.name)) {
                        var105.name = var91;
                        var105.previousName = var93;
                        var91 = null;
                        break;
                     }
                  }

                  if(null != var91 && Client.ignoreCount < 400) {
                     Ignore var72 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var72;
                     var72.name = var91;
                     var72.previousName = var93;
                     ++Client.ignoreCount;
                  }
               }

               Client.field470 = Client.field462;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 55) {
               class112.field1760 = RSCanvas.method2072(Client.field323.readUnsignedByte());
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 203) {
               Actor.method642();
               Client.weight = Client.field323.readShort();
               Client.field474 = Client.field462;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 37) {
               var1 = Client.field323.method3037();
               var2 = Client.field323.method2972();
               class146.settings[var1] = var2;
               if(var2 != class146.widgetSettings[var1]) {
                  class146.widgetSettings[var1] = var2;
               }

               class182.method3296(var1);
               Client.field393[++Client.field561 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 7) {
               Client.field325 = Client.field323.method2962() * 30;
               Client.field474 = Client.field462;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 116) {
               Friend.field153 = Client.field323.readUnsignedByte();
               class18.field199 = Client.field323.readUnsignedByte();

               while(Client.field323.offset < Client.field324) {
                  Client.packetOpcode = Client.field323.readUnsignedByte();
                  class38.method764();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 159) {
               class25.method614(Client.field323.method2934());
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 118) {
               var1 = Client.field323.readUnsignedByte();
               if(Client.field323.readUnsignedByte() == 0) {
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  Client.field323.offset += 18;
               } else {
                  --Client.field323.offset;
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer(Client.field323, false);
               }

               Client.field415 = Client.field462;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 126) {
               Client.field514 = Client.field323.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 33) {
               Client.field526 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  Client.field527[var1] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 72) {
               var1 = Client.field323.readUnsignedShort();
               var2 = Client.field323.method2974();
               var22 = class37.method759(var2);
               if(var22 != null && var22.type == 0) {
                  if(var1 > var22.scrollHeight - var22.height) {
                     var1 = var22.scrollHeight - var22.height;
                  }

                  if(var1 < 0) {
                     var1 = 0;
                  }

                  if(var1 != var22.scrollY) {
                     var22.scrollY = var1;
                     class2.method28(var22);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var26;
            if(Client.packetOpcode == 65) {
               var1 = Client.field323.readUnsignedShort();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = Client.field323.readUnsignedShort();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = Client.field323.method3132();
               var4 = Client.field323.method2972();

               for(var23 = var2; var23 <= var1; ++var23) {
                  var26 = ((long)var4 << 32) + (long)var23;
                  Node var75 = Client.widgetFlags.method2331(var26);
                  if(null != var75) {
                     var75.unlink();
                  }

                  Client.widgetFlags.method2333(new class133(var3), var26);
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var10;
            int var13;
            long var28;
            long var30;
            if(Client.packetOpcode == 243) {
               var24 = Client.field323.method2934();
               var28 = (long)Client.field323.readUnsignedShort();
               var30 = (long)Client.field323.read24BitInt();
               class177 var104 = (class177)CombatInfoListHolder.method732(class114.method2189(), Client.field323.readUnsignedByte());
               long var32 = (var28 << 32) + var30;
               boolean var78 = false;

               for(var10 = 0; var10 < 100; ++var10) {
                  if(var32 == Client.field558[var10]) {
                     var78 = true;
                     break;
                  }
               }

               if(class1.method20(var24)) {
                  var78 = true;
               }

               if(!var78 && Client.field397 == 0) {
                  Client.field558[Client.field499] = var32;
                  Client.field499 = (Client.field499 + 1) % 100;
                  class166 var79 = Client.field323;

                  String var81;
                  try {
                     var13 = var79.method2939();
                     if(var13 > 32767) {
                        var13 = 32767;
                     }

                     byte[] var85 = new byte[var13];
                     var79.offset += class210.field3110.method2852(var79.payload, var79.offset, var85, 0, var13);
                     String var83 = class72.method1414(var85, 0, var13);
                     var81 = var83;
                  } catch (Exception var58) {
                     var81 = "Cabbage";
                  }

                  var81 = FontTypeFace.method3937(RSCanvas.method2070(var81));
                  byte var82;
                  if(var104.field2656) {
                     var82 = 7;
                  } else {
                     var82 = 3;
                  }

                  if(var104.field2647 != -1) {
                     ChatLineBuffer.sendGameMessage(var82, class114.method2191(var104.field2647) + var24, var81);
                  } else {
                     ChatLineBuffer.sendGameMessage(var82, var24, var81);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var110;
            if(Client.packetOpcode == 103) {
               var1 = Client.field323.method3132();
               var110 = class37.method759(var1);

               for(var3 = 0; var3 < var110.itemIds.length; ++var3) {
                  var110.itemIds[var3] = -1;
                  var110.itemIds[var3] = 0;
               }

               class2.method28(var110);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 130) {
               var1 = Client.field323.method2963();
               var2 = Client.field323.method2963();
               var3 = Client.field323.method3062();
               var4 = Client.field323.readUnsignedShort();
               var71 = class37.method759(var3);
               if(var71.rotationX != var1 || var4 != var71.rotationZ || var2 != var71.field2103) {
                  var71.rotationX = var1;
                  var71.rotationZ = var4;
                  var71.field2103 = var2;
                  class2.method28(var71);
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var38;
            long var39;
            if(Client.packetOpcode == 195) {
               var1 = Client.field324 + Client.field323.offset;
               var2 = Client.field323.readUnsignedShort();
               var3 = Client.field323.readUnsignedShort();
               if(var2 != Client.widgetRoot) {
                  Client.widgetRoot = var2;
                  class8.method117(false);
                  class2.method23(Client.widgetRoot);
                  class119.method2280(Client.widgetRoot);

                  for(var4 = 0; var4 < 100; ++var4) {
                     Client.field482[var4] = true;
                  }
               }

               WidgetNode var116;
               for(; var3-- > 0; var116.field187 = true) {
                  var4 = Client.field323.method3062();
                  var23 = Client.field323.readUnsignedShort();
                  var6 = Client.field323.readUnsignedByte();
                  var116 = (WidgetNode)Client.componentTable.method2331((long)var4);
                  if(null != var116 && var23 != var116.id) {
                     class39.method768(var116, true);
                     var116 = null;
                  }

                  if(var116 == null) {
                     var116 = class65.method1186(var4, var23, var6);
                  }
               }

               for(var90 = (WidgetNode)Client.componentTable.method2334(); null != var90; var90 = (WidgetNode)Client.componentTable.method2335()) {
                  if(var90.field187) {
                     var90.field187 = false;
                  } else {
                     class39.method768(var90, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.field323.offset < var1) {
                  var4 = Client.field323.method3062();
                  var23 = Client.field323.readUnsignedShort();
                  var6 = Client.field323.readUnsignedShort();
                  var7 = Client.field323.method3062();

                  for(var38 = var23; var38 <= var6; ++var38) {
                     var39 = (long)var38 + ((long)var4 << 32);
                     Client.widgetFlags.method2333(new class133(var7), var39);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 201) {
               var24 = Client.field323.method2934();
               Object[] var118 = new Object[var24.length() + 1];

               for(var3 = var24.length() - 1; var3 >= 0; --var3) {
                  if(var24.charAt(var3) == 115) {
                     var118[var3 + 1] = Client.field323.method2934();
                  } else {
                     var118[var3 + 1] = new Integer(Client.field323.method3062());
                  }
               }

               var118[0] = new Integer(Client.field323.method3062());
               class18 var101 = new class18();
               var101.field198 = var118;
               class9.method118(var101);
               Client.packetOpcode = -1;
               return true;
            }

            String var111;
            if(Client.packetOpcode == 237) {
               var1 = Client.field323.method3092();
               var111 = Client.field323.method2934();
               var3 = Client.field323.readUnsignedByte();
               if(var1 >= 1 && var1 <= 8) {
                  if(var111.equalsIgnoreCase("null")) {
                     var111 = null;
                  }

                  Client.playerOptions[var1 - 1] = var111;
                  Client.playerOptionsPriority[var1 - 1] = var3 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 59) {
               World var106 = new World();
               var106.address = Client.field323.method2934();
               var106.id = Client.field323.readUnsignedShort();
               var2 = Client.field323.method3062();
               var106.mask = var2;
               class11.setGameState(45);
               class177.field2657.method2064();
               class177.field2657 = null;
               class47.method891(var106);
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 238) {
               var1 = Client.field323.method2965();
               var2 = Client.field323.method3132();
               var3 = Client.field323.method2966();
               var89 = class37.method759(var2);
               if(var3 != var89.originalX || var89.originalY != var1 || var89.field2111 != 0 || var89.field2179 != 0) {
                  var89.originalX = var3;
                  var89.originalY = var1;
                  var89.field2111 = 0;
                  var89.field2179 = 0;
                  class2.method28(var89);
                  class103.method1965(var89);
                  if(var89.type == 0) {
                     class22.method233(Widget.widgets[var2 >> 16], var89, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 213) {
               Actor.method642();
               Client.energy = Client.field323.readUnsignedByte();
               Client.field474 = Client.field462;
               Client.packetOpcode = -1;
               return true;
            }

            String var113;
            if(Client.packetOpcode == 218) {
               var24 = Client.field323.method2934();
               class166 var99 = Client.field323;

               try {
                  var23 = var99.method2939();
                  if(var23 > 32767) {
                     var23 = 32767;
                  }

                  byte[] var102 = new byte[var23];
                  var99.offset += class210.field3110.method2852(var99.payload, var99.offset, var102, 0, var23);
                  var113 = class72.method1414(var102, 0, var23);
                  var93 = var113;
               } catch (Exception var57) {
                  var93 = "Cabbage";
               }

               var93 = FontTypeFace.method3937(RSCanvas.method2070(var93));
               ChatLineBuffer.sendGameMessage(6, var24, var93);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 16) {
               Client.flagX = Client.field323.readUnsignedByte();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.field323.readUnsignedByte();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 125) {
               class45.field901 = 0;

               for(var1 = 0; var1 < 2048; ++var1) {
                  class45.field900[var1] = null;
                  class45.field899[var1] = 1;
               }

               for(var1 = 0; var1 < 2048; ++var1) {
                  Client.cachedPlayers[var1] = null;
               }

               class26.method621(Client.field323);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 60) {
               class3.method43(true);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 8) {
               var1 = Client.field323.method3062();
               WidgetNode var115 = (WidgetNode)Client.componentTable.method2331((long)var1);
               if(null != var115) {
                  class39.method768(var115, true);
               }

               if(null != Client.field309) {
                  class2.method28(Client.field309);
                  Client.field309 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 110) {
               Client.field495 = Client.field323.readUnsignedByte();
               Client.field496 = Client.field323.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 19) {
               ChatLineBuffer.xteaChanged(true);
               Client.field323.method3190();
               var1 = Client.field323.readUnsignedShort();
               class38.method762(Client.field323, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 134) {
               var1 = Client.field323.method2953();
               var2 = Client.field323.method3037();
               var3 = Client.field323.method2974();
               var90 = (WidgetNode)Client.componentTable.method2331((long)var3);
               if(var90 != null) {
                  class39.method768(var90, var2 != var90.id);
               }

               class65.method1186(var3, var2, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 109) {
               var1 = Client.field323.method2963();
               var2 = Client.field323.readUnsignedShort();
               var3 = Client.field323.method2972();
               var89 = class37.method759(var3);
               var89.field2105 = (var2 << 16) + var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 205) {
               var1 = Client.field323.readUnsignedShort();
               var2 = Client.field323.method2974();
               var22 = class37.method759(var2);
               if(var22.modelType != 2 || var1 != var22.modelId) {
                  var22.modelType = 2;
                  var22.modelId = var1;
                  class2.method28(var22);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 11) {
               class18.field199 = Client.field323.method2953();
               Friend.field153 = Client.field323.method3092();

               for(var1 = class18.field199; var1 < class18.field199 + 8; ++var1) {
                  for(var2 = Friend.field153; var2 < Friend.field153 + 8; ++var2) {
                     if(null != Client.groundItemDeque[class48.plane][var1][var2]) {
                        Client.groundItemDeque[class48.plane][var1][var2] = null;
                        class11.groundItemSpawned(var1, var2);
                     }
                  }
               }

               for(class25 var100 = (class25)Client.field300.method2403(); var100 != null; var100 = (class25)Client.field300.method2398()) {
                  if(var100.field564 >= class18.field199 && var100.field564 < class18.field199 + 8 && var100.field565 >= Friend.field153 && var100.field565 < 8 + Friend.field153 && class48.plane == var100.field575) {
                     var100.field573 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 202) {
               var1 = Client.field323.method2962();
               class94.method1900(var1);
               Client.interfaceItemTriggers[++Client.field466 - 1 & 31] = var1 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            int var42;
            class166 var95;
            if(Client.packetOpcode == 221) {
               var95 = Client.field323;
               var2 = Client.field324;
               ClassInfo var96 = new ClassInfo();
               var96.field3220 = var95.readUnsignedByte();
               var96.field3224 = var95.method3062();
               var96.field3226 = new int[var96.field3220];
               var96.field3223 = new int[var96.field3220];
               var96.fields = new Field[var96.field3220];
               var96.field3225 = new int[var96.field3220];
               var96.methods = new Method[var96.field3220];
               var96.args = new byte[var96.field3220][][];

               for(var4 = 0; var4 < var96.field3220; ++var4) {
                  try {
                     var23 = var95.readUnsignedByte();
                     String var98;
                     if(var23 != 0 && var23 != 1 && var23 != 2) {
                        if(var23 == 3 || var23 == 4) {
                           var98 = var95.method2934();
                           var113 = var95.method2934();
                           var38 = var95.readUnsignedByte();
                           String[] var119 = new String[var38];

                           for(var10 = 0; var10 < var38; ++var10) {
                              var119[var10] = var95.method2934();
                           }

                           String var109 = var95.method2934();
                           byte[][] var11 = new byte[var38][];
                           if(var23 == 3) {
                              for(var42 = 0; var42 < var38; ++var42) {
                                 var13 = var95.method3062();
                                 var11[var42] = new byte[var13];
                                 var95.method3095(var11[var42], 0, var13);
                              }
                           }

                           var96.field3226[var4] = var23;
                           Class[] var80 = new Class[var38];

                           for(var13 = 0; var13 < var38; ++var13) {
                              var80[var13] = class186.method3417(var119[var13]);
                           }

                           Class var108 = class186.method3417(var109);
                           if(class186.method3417(var98).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var84 = class186.method3417(var98).getDeclaredMethods();
                           Method[] var15 = var84;

                           for(int var16 = 0; var16 < var15.length; ++var16) {
                              Method var86 = var15[var16];
                              if(Reflection.getMethodName(var86).equals(var113)) {
                                 Class[] var18 = Reflection.getParameterTypes(var86);
                                 if(var80.length == var18.length) {
                                    boolean var19 = true;

                                    for(int var20 = 0; var20 < var80.length; ++var20) {
                                       if(var18[var20] != var80[var20]) {
                                          var19 = false;
                                          break;
                                       }
                                    }

                                    if(var19 && var108 == var86.getReturnType()) {
                                       var96.methods[var4] = var86;
                                    }
                                 }
                              }
                           }

                           var96.args[var4] = var11;
                        }
                     } else {
                        var98 = var95.method2934();
                        var113 = var95.method2934();
                        var38 = 0;
                        if(var23 == 1) {
                           var38 = var95.method3062();
                        }

                        var96.field3226[var4] = var23;
                        var96.field3225[var4] = var38;
                        if(class186.method3417(var98).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var96.fields[var4] = Reflection.findField(class186.method3417(var98), var113);
                     }
                  } catch (ClassNotFoundException var60) {
                     var96.field3223[var4] = -1;
                  } catch (SecurityException var61) {
                     var96.field3223[var4] = -2;
                  } catch (NullPointerException var62) {
                     var96.field3223[var4] = -3;
                  } catch (Exception var63) {
                     var96.field3223[var4] = -4;
                  } catch (Throwable var64) {
                     var96.field3223[var4] = -5;
                  }
               }

               class227.field3232.method2347(var96);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 53) {
               var1 = Client.field323.method2974();
               var2 = Client.field323.readUnsignedShort();
               var3 = var2 >> 10 & 31;
               var4 = var2 >> 5 & 31;
               var23 = var2 & 31;
               var6 = (var23 << 3) + (var4 << 11) + (var3 << 19);
               Widget var112 = class37.method759(var1);
               if(var112.textColor != var6) {
                  var112.textColor = var6;
                  class2.method28(var112);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 178) {
               ChatLineBuffer.xteaChanged(false);
               Client.field323.method3190();
               var1 = Client.field323.readUnsignedShort();
               class38.method762(Client.field323, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 39) {
               if(Client.widgetRoot != -1) {
                  class148.method2769(Client.widgetRoot, 0);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 87) {
               Client.field296 = Client.field323.readUnsignedByte();
               if(Client.field296 == 1) {
                  Client.field297 = Client.field323.readUnsignedShort();
               }

               if(Client.field296 >= 2 && Client.field296 <= 6) {
                  if(Client.field296 == 2) {
                     Client.field302 = 64;
                     Client.field303 = 64;
                  }

                  if(Client.field296 == 3) {
                     Client.field302 = 0;
                     Client.field303 = 64;
                  }

                  if(Client.field296 == 4) {
                     Client.field302 = 128;
                     Client.field303 = 64;
                  }

                  if(Client.field296 == 5) {
                     Client.field302 = 64;
                     Client.field303 = 0;
                  }

                  if(Client.field296 == 6) {
                     Client.field302 = 64;
                     Client.field303 = 128;
                  }

                  Client.field296 = 2;
                  Client.field348 = Client.field323.readUnsignedShort();
                  Client.field428 = Client.field323.readUnsignedShort();
                  Client.field301 = Client.field323.readUnsignedByte();
               }

               if(Client.field296 == 10) {
                  Client.field298 = Client.field323.readUnsignedShort();
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var43;
            if(Client.packetOpcode == 146) {
               var24 = Client.field323.method2934();
               var28 = Client.field323.method2932();
               var30 = (long)Client.field323.readUnsignedShort();
               var26 = (long)Client.field323.read24BitInt();
               class177 var8 = (class177)CombatInfoListHolder.method732(class114.method2189(), Client.field323.readUnsignedByte());
               var39 = var26 + (var30 << 32);
               var43 = false;

               for(var42 = 0; var42 < 100; ++var42) {
                  if(Client.field558[var42] == var39) {
                     var43 = true;
                     break;
                  }
               }

               if(var8.field2654 && class1.method20(var24)) {
                  var43 = true;
               }

               if(!var43 && Client.field397 == 0) {
                  Client.field558[Client.field499] = var39;
                  Client.field499 = (Client.field499 + 1) % 100;
                  class166 var34 = Client.field323;

                  String var14;
                  try {
                     int var44 = var34.method2939();
                     if(var44 > 32767) {
                        var44 = 32767;
                     }

                     byte[] var45 = new byte[var44];
                     var34.offset += class210.field3110.method2852(var34.payload, var34.offset, var45, 0, var44);
                     String var17 = class72.method1414(var45, 0, var44);
                     var14 = var17;
                  } catch (Exception var56) {
                     var14 = "Cabbage";
                  }

                  var14 = FontTypeFace.method3937(RSCanvas.method2070(var14));
                  if(var8.field2647 != -1) {
                     DecorativeObject.addChatMessage(9, class114.method2191(var8.field2647) + var24, var14, class151.method2837(var28));
                  } else {
                     DecorativeObject.addChatMessage(9, var24, var14, class151.method2837(var28));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 35) {
               var1 = Client.field323.readUnsignedShort();
               var2 = Client.field323.readUnsignedByte();
               var3 = Client.field323.readUnsignedShort();
               GroundObject.method1547(var1, var2, var3);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 223) {
               var1 = Client.field323.method2963();
               var2 = Client.field323.method2974();
               var22 = class37.method759(var2);
               if(var22.modelType != 1 || var22.modelId != var1) {
                  var22.modelType = 1;
                  var22.modelId = var1;
                  class2.method28(var22);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 140) {
               class3.method43(false);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 124) {
               var69 = Client.field323.readUnsignedByte() == 1;
               if(var69) {
                  class139.field1946 = class22.method224() - Client.field323.method2932();
                  class26.field576 = new class1(Client.field323, true);
               } else {
                  class26.field576 = null;
               }

               Client.field293 = Client.field462;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 31) {
               var1 = Client.field323.readUnsignedShort();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               if(var1 == -1 && !Client.field517) {
                  class85.method1702();
               } else if(var1 != -1 && Client.field516 != var1 && Client.field515 != 0 && !Client.field517) {
                  class184 var114 = ChatMessages.field923;
                  var3 = Client.field515;
                  class138.field1910 = 1;
                  class1.field10 = var114;
                  class138.field1915 = var1;
                  ChatLineBuffer.field971 = 0;
                  class97.field1631 = var3;
                  class138.field1912 = false;
                  class15.field165 = 2;
               }

               Client.field516 = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 78) {
               var1 = Client.field323.method2968();
               var2 = Client.field323.method3037();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(Client.field515 != 0 && var2 != -1) {
                  class159.method2909(class11.field109, var2, 0, Client.field515, false);
                  Client.field517 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 45) {
               while(Client.field323.offset < Client.field324) {
                  var69 = Client.field323.readUnsignedByte() == 1;
                  var111 = Client.field323.method2934();
                  var91 = Client.field323.method2934();
                  var4 = Client.field323.readUnsignedShort();
                  var23 = Client.field323.readUnsignedByte();
                  var6 = Client.field323.readUnsignedByte();
                  boolean var76 = (var6 & 2) != 0;
                  boolean var117 = (var6 & 1) != 0;
                  if(var4 > 0) {
                     Client.field323.method2934();
                     Client.field323.readUnsignedByte();
                     Client.field323.method3062();
                  }

                  Client.field323.method2934();

                  for(int var9 = 0; var9 < Client.friendCount; ++var9) {
                     Friend var35 = Client.friends[var9];
                     if(!var69) {
                        if(var111.equals(var35.name)) {
                           if(var35.world != var4) {
                              var43 = true;

                              for(class16 var12 = (class16)Client.field409.method2417(); null != var12; var12 = (class16)Client.field409.method2418()) {
                                 if(var12.field167.equals(var111)) {
                                    if(var4 != 0 && var12.field175 == 0) {
                                       var12.method2426();
                                       var43 = false;
                                    } else if(var4 == 0 && var12.field175 != 0) {
                                       var12.method2426();
                                       var43 = false;
                                    }
                                 }
                              }

                              if(var43) {
                                 Client.field409.method2416(new class16(var111, var4));
                              }

                              var35.world = var4;
                           }

                           var35.previousName = var91;
                           var35.rank = var23;
                           var35.field159 = var76;
                           var35.field148 = var117;
                           var111 = null;
                           break;
                        }
                     } else if(var91.equals(var35.name)) {
                        var35.name = var111;
                        var35.previousName = var91;
                        var111 = null;
                        break;
                     }
                  }

                  if(var111 != null && Client.friendCount < 400) {
                     Friend var41 = new Friend();
                     Client.friends[Client.friendCount] = var41;
                     var41.name = var111;
                     var41.previousName = var91;
                     var41.world = var4;
                     var41.rank = var23;
                     var41.field159 = var76;
                     var41.field148 = var117;
                     ++Client.friendCount;
                  }
               }

               Client.field333 = 2;
               Client.field470 = Client.field462;
               var69 = false;
               var2 = Client.friendCount;

               while(var2 > 0) {
                  var69 = true;
                  --var2;

                  for(var3 = 0; var3 < var2; ++var3) {
                     var68 = false;
                     Friend var70 = Client.friends[var3];
                     Friend var97 = Client.friends[1 + var3];
                     if(var70.world != Client.world && Client.world == var97.world) {
                        var68 = true;
                     }

                     if(!var68 && var70.world == 0 && var97.world != 0) {
                        var68 = true;
                     }

                     if(!var68 && !var70.field159 && var97.field159) {
                        var68 = true;
                     }

                     if(!var68 && !var70.field148 && var97.field148) {
                        var68 = true;
                     }

                     if(var68) {
                        Friend var37 = Client.friends[var3];
                        Client.friends[var3] = Client.friends[var3 + 1];
                        Client.friends[1 + var3] = var37;
                        var69 = false;
                     }
                  }

                  if(var69) {
                     break;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 47) {
               var1 = Client.field323.method2963();
               Client.widgetRoot = var1;
               class8.method117(false);
               class2.method23(var1);
               class119.method2280(Client.widgetRoot);

               for(var2 = 0; var2 < 100; ++var2) {
                  Client.field482[var2] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 169) {
               Client.field323.offset += 28;
               if(Client.field323.method2949()) {
                  var95 = Client.field323;
                  var2 = Client.field323.offset - 28;
                  if(class104.field1693 != null) {
                     try {
                        class104.field1693.method1404(0L);
                        class104.field1693.method1394(var95.payload, var2, 24);
                     } catch (Exception var55) {
                        ;
                     }
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 236) {
               var1 = Client.field323.method3062();
               var110 = class37.method759(var1);
               var110.modelType = 3;
               var110.modelId = VertexNormal.localPlayer.composition.method2737();
               class2.method28(var110);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 216) {
               for(var1 = 0; var1 < class187.field2755; ++var1) {
                  class187 var36 = class109.method2046(var1);
                  if(null != var36) {
                     class146.settings[var1] = 0;
                     class146.widgetSettings[var1] = 0;
                  }
               }

               Actor.method642();
               Client.field561 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 28) {
               Client.field471 = Client.field462;
               if(Client.field324 == 0) {
                  Client.field299 = null;
                  Client.clanChatOwner = null;
                  class72.clanChatCount = 0;
                  class85.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.clanChatOwner = Client.field323.method2934();
               long var46 = Client.field323.method2932();
               Client.field299 = class60.method1147(var46);
               class166.field2291 = Client.field323.readByte();
               var3 = Client.field323.readUnsignedByte();
               if(var3 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               class72.clanChatCount = var3;
               XClanMember[] var88 = new XClanMember[100];

               for(var23 = 0; var23 < class72.clanChatCount; ++var23) {
                  var88[var23] = new XClanMember();
                  var88[var23].username = Client.field323.method2934();
                  var88[var23].field268 = Overlay.method3751(var88[var23].username, Client.field282);
                  var88[var23].world = Client.field323.readUnsignedShort();
                  var88[var23].rank = Client.field323.readByte();
                  Client.field323.method2934();
                  if(var88[var23].username.equals(VertexNormal.localPlayer.name)) {
                     Buffer.field2265 = var88[var23].rank;
                  }
               }

               var103 = false;
               var7 = class72.clanChatCount;

               while(var7 > 0) {
                  var103 = true;
                  --var7;

                  for(var38 = 0; var38 < var7; ++var38) {
                     if(var88[var38].field268.compareTo(var88[var38 + 1].field268) > 0) {
                        XClanMember var25 = var88[var38];
                        var88[var38] = var88[var38 + 1];
                        var88[1 + var38] = var25;
                        var103 = false;
                     }
                  }

                  if(var103) {
                     break;
                  }
               }

               class85.clanMembers = var88;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 177) {
               for(var1 = 0; var1 < Client.cachedPlayers.length; ++var1) {
                  if(Client.cachedPlayers[var1] != null) {
                     Client.cachedPlayers[var1].animation = -1;
                  }
               }

               for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                  if(Client.cachedNPCs[var1] != null) {
                     Client.cachedNPCs[var1].animation = -1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 227) {
               var1 = Client.field323.method3062();
               var2 = Client.field323.method3062();
               if(null == class11.field110 || !class11.field110.isValid()) {
                  try {
                     Iterator var94 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var94.hasNext()) {
                        GarbageCollectorMXBean var87 = (GarbageCollectorMXBean)var94.next();
                        if(var87.isValid()) {
                           class11.field110 = var87;
                           Client.field556 = -1L;
                           Client.field349 = -1L;
                        }
                     }
                  } catch (Throwable var59) {
                     ;
                  }
               }

               long var48 = class22.method224();
               var23 = -1;
               if(null != class11.field110) {
                  var26 = class11.field110.getCollectionTime();
                  if(-1L != Client.field349) {
                     long var50 = var26 - Client.field349;
                     long var52 = var48 - Client.field556;
                     if(0L != var52) {
                        var23 = (int)(var50 * 100L / var52);
                     }
                  }

                  Client.field349 = var26;
                  Client.field556 = var48;
               }

               Client.field321.method3195(50);
               Client.field321.method3057(var1);
               Client.field321.method2969(var2);
               Client.field321.method2952(var23);
               Client.field321.method2951(GameEngine.FPS);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 133) {
               var1 = Client.field323.method3062();
               var2 = Client.field323.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var22 = class37.method759(var1);
               } else {
                  var22 = null;
               }

               if(var22 != null) {
                  for(var4 = 0; var4 < var22.itemIds.length; ++var4) {
                     var22.itemIds[var4] = 0;
                     var22.itemQuantities[var4] = 0;
                  }
               }

               XItemContainer var21 = (XItemContainer)XItemContainer.itemContainers.method2331((long)var2);
               if(null != var21) {
                  for(var23 = 0; var23 < var21.itemIds.length; ++var23) {
                     var21.itemIds[var23] = -1;
                     var21.stackSizes[var23] = 0;
                  }
               }

               var4 = Client.field323.readUnsignedShort();

               for(var23 = 0; var23 < var4; ++var23) {
                  var6 = Client.field323.method3092();
                  if(var6 == 255) {
                     var6 = Client.field323.method3132();
                  }

                  var7 = Client.field323.method2963();
                  if(var22 != null && var23 < var22.itemIds.length) {
                     var22.itemIds[var23] = var7;
                     var22.itemQuantities[var23] = var6;
                  }

                  class6.method94(var2, var23, var7 - 1, var6);
               }

               if(var22 != null) {
                  class2.method28(var22);
               }

               Actor.method642();
               Client.interfaceItemTriggers[++Client.field466 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 144) {
               var1 = Client.field323.method2939();
               var67 = Client.field323.readUnsignedByte() == 1;
               var91 = "";
               var68 = false;
               if(var67) {
                  var91 = Client.field323.method2934();
                  if(class1.method20(var91)) {
                     var68 = true;
                  }
               }

               String var5 = Client.field323.method2934();
               if(!var68) {
                  ChatLineBuffer.sendGameMessage(var1, var91, var5);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 226) {
               Client.field526 = true;
               class175.field2635 = Client.field323.readUnsignedByte();
               class105.field1723 = Client.field323.readUnsignedByte();
               Frames.field1569 = Client.field323.readUnsignedShort();
               Client.field399 = Client.field323.readUnsignedByte();
               class49.field959 = Client.field323.readUnsignedByte();
               if(class49.field959 >= 100) {
                  var1 = class175.field2635 * 128 + 64;
                  var2 = class105.field1723 * 128 + 64;
                  var3 = Renderable.method1883(var1, var2, class48.plane) - Frames.field1569;
                  var4 = var1 - class202.cameraX;
                  var23 = var3 - class32.cameraZ;
                  var6 = var2 - class16.cameraY;
                  var7 = (int)Math.sqrt((double)(var4 * var4 + var6 * var6));
                  FloorUnderlayDefinition.cameraPitch = (int)(Math.atan2((double)var23, (double)var7) * 325.949D) & 2047;
                  class3.cameraYaw = (int)(Math.atan2((double)var4, (double)var6) * -325.949D) & 2047;
                  if(FloorUnderlayDefinition.cameraPitch < 128) {
                     FloorUnderlayDefinition.cameraPitch = 128;
                  }

                  if(FloorUnderlayDefinition.cameraPitch > 383) {
                     FloorUnderlayDefinition.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 154) {
               var24 = Client.field323.method2934();
               var2 = Client.field323.method3062();
               var22 = class37.method759(var2);
               if(!var24.equals(var22.text)) {
                  var22.text = var24;
                  class2.method28(var22);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 38) {
               var1 = Client.field323.method3132();
               class99.field1649 = class63.field1093.method1960(var1);
               Client.packetOpcode = -1;
               return true;
            }

            class32.method709("" + Client.packetOpcode + "," + Client.field329 + "," + Client.field330 + "," + Client.field324, (Throwable)null);
            class114.method2188();
         } catch (IOException var65) {
            class1.method16();
         } catch (Exception var66) {
            var24 = "" + Client.packetOpcode + "," + Client.field329 + "," + Client.field330 + "," + Client.field324 + "," + (VertexNormal.localPlayer.pathX[0] + class114.baseX) + "," + (VertexNormal.localPlayer.pathY[0] + CombatInfo1.baseY) + ",";

            for(var2 = 0; var2 < Client.field324 && var2 < 50; ++var2) {
               var24 = var24 + Client.field323.payload[var2] + ",";
            }

            class32.method709(var24, var66);
            class114.method2188();
         }

         return true;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Lclass195;",
      garbageValue = "-497819735"
   )
   public static class195 method1464(int var0) {
      class195 var1 = (class195)class195.field2838.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class195.field2848.getConfigData(8, var0);
         var1 = new class195();
         if(var2 != null) {
            var1.method3548(new Buffer(var2));
         }

         class195.field2838.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("sf")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZI)V",
      garbageValue = "1169286867"
   )
   protected static final void method1465(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class32.canvas.getGraphics();
         if(ChatLineBuffer.field970 == null) {
            ChatLineBuffer.field970 = new java.awt.Font("Helvetica", 1, 13);
            class7.field60 = class32.canvas.getFontMetrics(ChatLineBuffer.field970);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, XItemContainer.field123, class143.field1999);
         }

         if(null == var2) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(null == class110.field1753) {
               class110.field1753 = class32.canvas.createImage(304, 34);
            }

            Graphics var5 = class110.field1753.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, 3 * var0, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(2 + var0 * 3, 2, 300 - 3 * var0, 30);
            var5.setFont(ChatLineBuffer.field970);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - class7.field60.stringWidth(var1)) / 2, 22);
            var4.drawImage(class110.field1753, XItemContainer.field123 / 2 - 152, class143.field1999 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = XItemContainer.field123 / 2 - 152;
            int var7 = class143.field1999 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(2 + var6, var7 + 2, 3 * var0, 30);
            var4.setColor(Color.black);
            var4.drawRect(1 + var6, var7 + 1, 301, 31);
            var4.fillRect(var0 * 3 + 2 + var6, 2 + var7, 300 - var0 * 3, 30);
            var4.setFont(ChatLineBuffer.field970);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - class7.field60.stringWidth(var1)) / 2, var7 + 22);
         }
      } catch (Exception var9) {
         class32.canvas.repaint();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass166;II)V",
      garbageValue = "-1249374450"
   )
   static void method1466(class166 var0, int var1) {
      boolean var2 = var0.method3176(1) == 1;
      if(var2) {
         class45.field909[++class45.field908 - 1] = var1;
      }

      int var3 = var0.method3176(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field265 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class45.field911[var1] = (var4.field263 << 28) + (class114.baseX + var4.pathX[0] >> 13 << 14) + (CombatInfo1.baseY + var4.pathY[0] >> 13);
            if(var4.field635 != -1) {
               class45.field906[var1] = var4.field635;
            } else {
               class45.field906[var1] = var4.field641;
            }

            class45.field907[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3176(1) != 0) {
               ChatMessages.method850(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3176(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field265 = true;
                  var4.field242 = var6;
                  var4.field253 = var7;
               } else {
                  var4.field265 = false;
                  var4.method243(var6, var7, class45.field899[var1]);
               }
            } else {
               var4.method250(var6, var7);
               var4.field265 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method3176(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method250(var6, var7);
               var4.field265 = false;
            } else if(var2) {
               var4.field265 = true;
               var4.field242 = var6;
               var4.field253 = var7;
            } else {
               var4.field265 = false;
               var4.method243(var6, var7, class45.field899[var1]);
            }

         } else {
            var5 = var0.method3176(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3176(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method250(var10, var11);
                  var4.field265 = false;
               } else if(var2) {
                  var4.field265 = true;
                  var4.field242 = var10;
                  var4.field253 = var11;
               } else {
                  var4.field265 = false;
                  var4.method243(var10, var11, class45.field899[var1]);
               }

               var4.field263 = (byte)(var7 + var4.field263 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class48.plane = var4.field263;
               }

            } else {
               var6 = var0.method3176(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var4.pathX[0] + class114.baseX + var8 & 16383) - class114.baseX;
               var11 = (var4.pathY[0] + CombatInfo1.baseY + var9 & 16383) - CombatInfo1.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field265 = true;
                     var4.field242 = var10;
                     var4.field253 = var11;
                  } else {
                     var4.field265 = false;
                     var4.method243(var10, var11, class45.field899[var1]);
                  }
               } else {
                  var4.method250(var10, var11);
                  var4.field265 = false;
               }

               var4.field263 = (byte)(var4.field263 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  class48.plane = var4.field263;
               }

            }
         }
      }
   }
}
