import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 236374041
   )
   int field2794 = 0;
   @ObfuscatedName("g")
   static NodeCache field2795 = new NodeCache(64);
   @ObfuscatedName("v")
   static NodeCache field2796 = new NodeCache(30);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2128974543
   )
   public int field2797 = -1;
   @ObfuscatedName("x")
   public static class182 field2798;
   @ObfuscatedName("m")
   short[] field2800;
   @ObfuscatedName("a")
   short[] field2801;
   @ObfuscatedName("i")
   short[] field2802;
   @ObfuscatedName("s")
   short[] field2803;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -557826643
   )
   int field2804;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1173660421
   )
   int field2805 = 128;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1959348815
   )
   int field2806 = 128;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -453820995
   )
   int field2807 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -738248147
   )
   int field2808 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 347898761
   )
   int field2810;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "20"
   )
   void method3533(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3534(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-77"
   )
   void method3534(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2804 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2797 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2806 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2805 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2794 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2807 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2808 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2800 = new short[var3];
            this.field2801 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2800[var4] = (short)var1.readUnsignedShort();
               this.field2801[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2802 = new short[var3];
            this.field2803 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2802[var4] = (short)var1.readUnsignedShort();
               this.field2803[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "740928658"
   )
   public final Model method3535(int var1) {
      Model var2 = (Model)field2796.get((long)this.field2810);
      if(null == var2) {
         ModelData var3 = ModelData.method1547(class202.field3081, this.field2804, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(null != this.field2800) {
            for(var4 = 0; var4 < this.field2800.length; ++var4) {
               var3.method1617(this.field2800[var4], this.field2801[var4]);
            }
         }

         if(this.field2802 != null) {
            for(var4 = 0; var4 < this.field2802.length; ++var4) {
               var3.method1612(this.field2802[var4], this.field2803[var4]);
            }
         }

         var2 = var3.method1624(this.field2807 + 64, 850 + this.field2808, -30, -50, -30);
         field2796.put(var2, (long)this.field2810);
      }

      Model var5;
      if(this.field2797 != -1 && var1 != -1) {
         var5 = TextureProvider.getAnimation(this.field2797).method3820(var2, var1);
      } else {
         var5 = var2.method1647(true);
      }

      if(this.field2806 != 128 || this.field2805 != 128) {
         var5.method1660(this.field2806, this.field2805, this.field2806);
      }

      if(this.field2794 != 0) {
         if(this.field2794 == 90) {
            var5.method1718();
         }

         if(this.field2794 == 180) {
            var5.method1718();
            var5.method1718();
         }

         if(this.field2794 == 270) {
            var5.method1718();
            var5.method1718();
            var5.method1718();
         }
      }

      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   static final void method3541() {
      try {
         if(Client.field321 == 0) {
            if(XGrandExchangeOffer.field30 != null) {
               XGrandExchangeOffer.field30.method2139();
               XGrandExchangeOffer.field30 = null;
            }

            class38.field800 = null;
            Client.field343 = false;
            Client.field322 = 0;
            Client.field321 = 1;
         }

         if(Client.field321 == 1) {
            if(class38.field800 == null) {
               class38.field800 = class114.field1793.method2055(BufferProvider.host, Client.field325);
            }

            if(class38.field800.field1670 == 2) {
               throw new IOException();
            }

            if(class38.field800.field1670 == 1) {
               XGrandExchangeOffer.field30 = new class110((Socket)class38.field800.field1674, class114.field1793);
               class38.field800 = null;
               Client.field321 = 2;
            }
         }

         if(Client.field321 == 2) {
            Client.field332.offset = 0;
            Client.field332.method2873(14);
            XGrandExchangeOffer.field30.method2148(Client.field332.payload, 0, 1);
            Client.field334.offset = 0;
            Client.field321 = 3;
         }

         int var0;
         if(Client.field321 == 3) {
            if(null != class36.field772) {
               class36.field772.method1153();
            }

            if(FaceNormal.field1570 != null) {
               FaceNormal.field1570.method1153();
            }

            var0 = XGrandExchangeOffer.field30.method2141();
            if(null != class36.field772) {
               class36.field772.method1153();
            }

            if(FaceNormal.field1570 != null) {
               FaceNormal.field1570.method1153();
            }

            if(var0 != 0) {
               class170.method3329(var0);
               return;
            }

            Client.field334.offset = 0;
            Client.field321 = 5;
         }

         int var1;
         int var2;
         if(Client.field321 == 5) {
            int[] var5 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field332.offset = 0;
            Client.field332.method2873(1);
            Client.field332.method2873(class41.field846.vmethod4107());
            Client.field332.method2874(var5[0]);
            Client.field332.method2874(var5[1]);
            Client.field332.method2874(var5[2]);
            Client.field332.method2874(var5[3]);
            switch(class41.field846.field1638) {
            case 0:
            case 3:
               Client.field332.method2871(class6.field54);
               Client.field332.offset += 5;
               break;
            case 1:
               Client.field332.method2874(((Integer)ObjectComposition.field2944.field692.get(Integer.valueOf(Tile.method1640(class41.username)))).intValue());
               Client.field332.offset += 4;
               break;
            case 2:
               Client.field332.offset += 8;
            }

            Client.field332.method2915(class41.field845);
            Client.field332.method2907(class39.field805, class39.field803);
            Client.field333.offset = 0;
            if(Client.gameState == 40) {
               Client.field333.method2873(18);
            } else {
               Client.field333.method2873(16);
            }

            Client.field333.method2872(0);
            var1 = Client.field333.offset;
            Client.field333.method2874(136);
            Client.field333.method2880(Client.field332.payload, 0, Client.field332.offset);
            var2 = Client.field333.offset;
            Client.field333.method2915(class41.username);
            Client.field333.method2873((Client.isResized?1:0) << 1 | (Client.field290?1:0));
            Client.field333.method2872(RSCanvas.field1756);
            Client.field333.method2872(class65.field1128);
            RSCanvas.method2171(Client.field333);
            Client.field333.method2915(Client.field303);
            Client.field333.method2874(class6.field44);
            Buffer var3 = new Buffer(class88.field1545.method4298());
            class88.field1545.method4297(var3);
            Client.field333.method2880(var3.payload, 0, var3.payload.length);
            Client.field333.method2873(class114.field1790);
            Client.field333.method2874(0);
            Client.field333.method2874(class5.field38.field2722);
            Client.field333.method2874(class0.field0.field2722);
            Client.field333.method2874(Client.field499.field2722);
            Client.field333.method2874(class40.field818.field2722);
            Client.field333.method2874(class150.field2041.field2722);
            Client.field333.method2874(class154.field2094.field2722);
            Client.field333.method2874(Client.field306.field2722);
            Client.field333.method2874(class9.field74.field2722);
            Client.field333.method2874(class39.field808.field2722);
            Client.field333.method2874(class8.field68.field2722);
            Client.field333.method2874(Friend.field146.field2722);
            Client.field333.method2874(WidgetNode.field175.field2722);
            Client.field333.method2874(Tile.field1358.field2722);
            Client.field333.method2874(GroundObject.field1308.field2722);
            Client.field333.method2874(WidgetNode.field180.field2722);
            Client.field333.method2874(class184.field2743.field2722);
            Client.field333.method2905(var5, var2, Client.field333.offset);
            Client.field333.method2882(Client.field333.offset - var1);
            XGrandExchangeOffer.field30.method2148(Client.field333.payload, 0, Client.field333.offset);
            Client.field332.method3143(var5);

            for(int var4 = 0; var4 < 4; ++var4) {
               var5[var4] += 50;
            }

            Client.field334.method3143(var5);
            Client.field321 = 6;
         }

         if(Client.field321 == 6 && XGrandExchangeOffer.field30.method2138() > 0) {
            var0 = XGrandExchangeOffer.field30.method2141();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field321 = 7;
            } else if(var0 == 2) {
               Client.field321 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field335 = -1;
               Client.field321 = 13;
            } else if(var0 == 23 && Client.field323 < 1) {
               ++Client.field323;
               Client.field321 = 0;
            } else {
               if(var0 != 29) {
                  class170.method3329(var0);
                  return;
               }

               Client.field321 = 11;
            }
         }

         if(Client.field321 == 7 && XGrandExchangeOffer.field30.method2138() > 0) {
            Client.field324 = (XGrandExchangeOffer.field30.method2141() + 3) * 60;
            Client.field321 = 8;
         }

         if(Client.field321 == 8) {
            Client.field322 = 0;
            class41.method864("You have only just left another world.", "Your profile will be transferred in:", Client.field324 / 60 + " seconds.");
            if(--Client.field324 <= 0) {
               Client.field321 = 0;
            }

         } else {
            if(Client.field321 == 9 && XGrandExchangeOffer.field30.method2138() >= 13) {
               boolean var10 = XGrandExchangeOffer.field30.method2141() == 1;
               XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, 4);
               Client.field334.offset = 0;
               boolean var11 = false;
               if(var10) {
                  var1 = Client.field334.method3158() << 24;
                  var1 |= Client.field334.method3158() << 16;
                  var1 |= Client.field334.method3158() << 8;
                  var1 |= Client.field334.method3158();
                  var2 = Tile.method1640(class41.username);
                  if(ObjectComposition.field2944.field692.size() >= 10 && !ObjectComposition.field2944.field692.containsKey(Integer.valueOf(var2))) {
                     Iterator var12 = ObjectComposition.field2944.field692.entrySet().iterator();
                     var12.next();
                     var12.remove();
                  }

                  ObjectComposition.field2944.field692.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class146.method2811();
               }

               Client.field425 = XGrandExchangeOffer.field30.method2141();
               Client.field458 = XGrandExchangeOffer.field30.method2141() == 1;
               Client.localInteractingIndex = XGrandExchangeOffer.field30.method2141();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += XGrandExchangeOffer.field30.method2141();
               Client.field411 = XGrandExchangeOffer.field30.method2141();
               XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, 1);
               Client.field334.offset = 0;
               Client.packetOpcode = Client.field334.method3158();
               XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, 2);
               Client.field334.offset = 0;
               Client.field335 = Client.field334.readUnsignedShort();

               try {
                  class100.method2039(Client.field556, "zap");
               } catch (Throwable var8) {
                  ;
               }

               Client.field321 = 10;
            }

            if(Client.field321 == 10) {
               if(XGrandExchangeOffer.field30.method2138() >= Client.field335) {
                  Client.field334.offset = 0;
                  XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, Client.field335);
                  WidgetNode.method199();
                  CombatInfoListHolder.method778(Client.field334);
                  class9.field75 = -1;
                  class36.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field321 == 11 && XGrandExchangeOffer.field30.method2138() >= 2) {
                  Client.field334.offset = 0;
                  XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, 2);
                  Client.field334.offset = 0;
                  class72.field1205 = Client.field334.readUnsignedShort();
                  Client.field321 = 12;
               }

               if(Client.field321 == 12 && XGrandExchangeOffer.field30.method2138() >= class72.field1205) {
                  Client.field334.offset = 0;
                  XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, class72.field1205);
                  Client.field334.offset = 0;
                  String var13 = Client.field334.readString();
                  String var7 = Client.field334.readString();
                  String var6 = Client.field334.readString();
                  class41.method864(var13, var7, var6);
                  World.setGameState(10);
               }

               if(Client.field321 != 13) {
                  ++Client.field322;
                  if(Client.field322 > 2000) {
                     if(Client.field323 < 1) {
                        if(Client.field325 == class212.field3145) {
                           Client.field325 = class20.field217;
                        } else {
                           Client.field325 = class212.field3145;
                        }

                        ++Client.field323;
                        Client.field321 = 0;
                     } else {
                        class170.method3329(-3);
                     }
                  }
               } else {
                  if(Client.field335 == -1) {
                     if(XGrandExchangeOffer.field30.method2138() < 2) {
                        return;
                     }

                     XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, 2);
                     Client.field334.offset = 0;
                     Client.field335 = Client.field334.readUnsignedShort();
                  }

                  if(XGrandExchangeOffer.field30.method2138() >= Client.field335) {
                     XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, Client.field335);
                     Client.field334.offset = 0;
                     var0 = Client.field335;
                     Client.field332.offset = 0;
                     Client.field334.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field345 = 1;
                     Client.field340 = -1;
                     Client.field341 = -1;
                     Client.field335 = 0;
                     Client.field337 = 0;
                     Client.field498 = 0;
                     class108.method2131();
                     Client.field526 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     WidgetNode.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var14 = Client.cachedNPCs[var1];
                        if(var14 != null) {
                           var14.interacting = -1;
                           var14.field630 = false;
                        }
                     }

                     XItemContainer.itemContainers = new XHashTable(32);
                     World.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field494[var1] = true;
                     }

                     class140.method2705();
                     CombatInfoListHolder.method778(Client.field334);
                     if(Client.field334.offset != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var9) {
         if(Client.field323 < 1) {
            if(class212.field3145 == Client.field325) {
               Client.field325 = class20.field217;
            } else {
               Client.field325 = class212.field3145;
            }

            ++Client.field323;
            Client.field321 = 0;
         } else {
            class170.method3329(-2);
         }
      }
   }
}
