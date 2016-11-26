import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("do")
public final class class110 implements Runnable {
   @ObfuscatedName("c")
   byte[] field1744;
   @ObfuscatedName("ew")
   static SpritePixels[] field1745;
   @ObfuscatedName("m")
   Socket field1746;
   @ObfuscatedName("h")
   boolean field1747 = false;
   @ObfuscatedName("w")
   class103 field1748;
   @ObfuscatedName("r")
   class102 field1749;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 360779067
   )
   int field1750 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1676193475
   )
   int field1752 = 0;
   @ObfuscatedName("d")
   OutputStream field1753;
   @ObfuscatedName("z")
   boolean field1754 = false;
   @ObfuscatedName("n")
   InputStream field1755;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "69"
   )
   static final void method2102() {
      try {
         if(Client.field452 == 0) {
            if(null != FileOnDisk.field1183) {
               FileOnDisk.field1183.method2121();
               FileOnDisk.field1183 = null;
            }

            class108.field1736 = null;
            Client.field425 = false;
            Client.field322 = 0;
            Client.field452 = 1;
         }

         if(Client.field452 == 1) {
            if(null == class108.field1736) {
               class108.field1736 = class15.field159.method1994(class18.host, class5.field55);
            }

            if(class108.field1736.field1661 == 2) {
               throw new IOException();
            }

            if(class108.field1736.field1661 == 1) {
               FileOnDisk.field1183 = new class110((Socket)class108.field1736.field1663, class15.field159);
               class108.field1736 = null;
               Client.field452 = 2;
            }
         }

         if(Client.field452 == 2) {
            Client.field330.offset = 0;
            Client.field330.method2975(14);
            FileOnDisk.field1183.method2107(Client.field330.payload, 0, 1);
            Client.field370.offset = 0;
            Client.field452 = 3;
         }

         int var0;
         if(Client.field452 == 3) {
            if(null != class11.field114) {
               class11.field114.method1046();
            }

            if(null != class15.field156) {
               class15.field156.method1046();
            }

            var0 = FileOnDisk.field1183.method2104();
            if(class11.field114 != null) {
               class11.field114.method1046();
            }

            if(class15.field156 != null) {
               class15.field156.method1046();
            }

            if(var0 != 0) {
               RSCanvas.method2130(var0);
               return;
            }

            Client.field370.offset = 0;
            Client.field452 = 5;
         }

         int var1;
         int var2;
         if(Client.field452 == 5) {
            int[] var5 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field330.offset = 0;
            Client.field330.method2975(1);
            Client.field330.method2975(class41.field842.vmethod4132());
            Client.field330.method2978(var5[0]);
            Client.field330.method2978(var5[1]);
            Client.field330.method2978(var5[2]);
            Client.field330.method2978(var5[3]);
            switch(class41.field842.field1632) {
            case 0:
               Client.field330.offset += 8;
               break;
            case 1:
               Client.field330.method2978(((Integer)Tile.field1343.field693.get(Integer.valueOf(class152.method2924(class41.username)))).intValue());
               Client.field330.offset += 4;
               break;
            case 2:
            case 3:
               Client.field330.method2977(class60.field1075);
               Client.field330.offset += 5;
            }

            Client.field330.method2981(class41.field834);
            Client.field330.method3056(class39.field801, class39.field803);
            Client.field331.offset = 0;
            if(Client.gameState == 40) {
               Client.field331.method2975(18);
            } else {
               Client.field331.method2975(16);
            }

            Client.field331.method2976(0);
            var1 = Client.field331.offset;
            Client.field331.method2978(127);
            Client.field331.method2984(Client.field330.payload, 0, Client.field330.offset);
            var2 = Client.field331.offset;
            Client.field331.method2981(class41.username);
            Client.field331.method2975((Client.isResized?1:0) << 1 | (Client.field288?1:0));
            Client.field331.method2976(class16.field169);
            Client.field331.method2976(class65.field1103);
            class36.method752(Client.field331);
            Client.field331.method2981(class10.field91);
            Client.field331.method2978(Client.field290);
            Buffer var3 = new Buffer(Renderable.field1536.method4331());
            Renderable.field1536.method4330(var3);
            Client.field331.method2984(var3.payload, 0, var3.payload.length);
            Client.field331.method2975(Client.field291);
            Client.field331.method2978(class139.field1952.field2720);
            Client.field331.method2978(class186.field2766.field2720);
            Client.field331.method2978(class143.field2015.field2720);
            Client.field331.method2978(class172.field2363.field2720);
            Client.field331.method2978(PlayerComposition.field2036.field2720);
            Client.field331.method2978(Client.field413.field2720);
            Client.field331.method2978(class34.field746.field2720);
            Client.field331.method2978(ItemLayer.field1202.field2720);
            Client.field331.method2978(class156.field2240.field2720);
            Client.field331.method2978(class189.field2788.field2720);
            Client.field331.method2978(Client.field317.field2720);
            Client.field331.method2978(Client.field332.field2720);
            Client.field331.method2978(XClanMember.field275.field2720);
            Client.field331.method2978(Client.field319.field2720);
            Client.field331.method2978(class148.field2050.field2720);
            Client.field331.method2978(class189.field2791.field2720);
            Client.field331.method3009(var5, var2, Client.field331.offset);
            Client.field331.method3127(Client.field331.offset - var1);
            FileOnDisk.field1183.method2107(Client.field331.payload, 0, Client.field331.offset);
            Client.field330.method3233(var5);

            for(int var4 = 0; var4 < 4; ++var4) {
               var5[var4] += 50;
            }

            Client.field370.method3233(var5);
            Client.field452 = 6;
         }

         if(Client.field452 == 6 && FileOnDisk.field1183.method2105() > 0) {
            var0 = FileOnDisk.field1183.method2104();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field452 = 7;
            } else if(var0 == 2) {
               Client.field452 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field564 = -1;
               Client.field452 = 13;
            } else if(var0 == 23 && Client.field323 < 1) {
               ++Client.field323;
               Client.field452 = 0;
            } else {
               if(var0 != 29) {
                  RSCanvas.method2130(var0);
                  return;
               }

               Client.field452 = 11;
            }
         }

         if(Client.field452 == 7 && FileOnDisk.field1183.method2105() > 0) {
            Client.field324 = (FileOnDisk.field1183.method2104() + 3) * 60;
            Client.field452 = 8;
         }

         if(Client.field452 == 8) {
            Client.field322 = 0;
            class3.method44("You have only just left another world.", "Your profile will be transferred in:", Client.field324 / 60 + " seconds.");
            if(--Client.field324 <= 0) {
               Client.field452 = 0;
            }

         } else {
            if(Client.field452 == 9 && FileOnDisk.field1183.method2105() >= 13) {
               boolean var10 = FileOnDisk.field1183.method2104() == 1;
               FileOnDisk.field1183.method2106(Client.field370.payload, 0, 4);
               Client.field370.offset = 0;
               boolean var11 = false;
               if(var10) {
                  var1 = Client.field370.method3235() << 24;
                  var1 |= Client.field370.method3235() << 16;
                  var1 |= Client.field370.method3235() << 8;
                  var1 |= Client.field370.method3235();
                  var2 = class152.method2924(class41.username);
                  if(Tile.field1343.field693.size() >= 10 && !Tile.field1343.field693.containsKey(Integer.valueOf(var2))) {
                     Iterator var12 = Tile.field1343.field693.entrySet().iterator();
                     var12.next();
                     var12.remove();
                  }

                  Tile.field1343.field693.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class3.method42();
               }

               Client.field503 = FileOnDisk.field1183.method2104();
               Client.field333 = FileOnDisk.field1183.method2104() == 1;
               Client.localInteractingIndex = FileOnDisk.field1183.method2104();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += FileOnDisk.field1183.method2104();
               Client.field410 = FileOnDisk.field1183.method2104();
               FileOnDisk.field1183.method2106(Client.field370.payload, 0, 1);
               Client.field370.offset = 0;
               Client.packetOpcode = Client.field370.method3235();
               FileOnDisk.field1183.method2106(Client.field370.payload, 0, 2);
               Client.field370.offset = 0;
               Client.field564 = Client.field370.readUnsignedShort();

               try {
                  Client var6 = Client.field281;
                  JSObject.getWindow(var6).call("zap", (Object[])null);
               } catch (Throwable var8) {
                  ;
               }

               Client.field452 = 10;
            }

            if(Client.field452 == 10) {
               if(FileOnDisk.field1183.method2105() >= Client.field564) {
                  Client.field370.offset = 0;
                  FileOnDisk.field1183.method2106(Client.field370.payload, 0, Client.field564);
                  Client.field295 = -1L;
                  Client.field298 = -1;
                  class107.field1729.field214 = 0;
                  class63.field1083 = true;
                  Client.field287 = true;
                  Client.field511 = -1L;
                  class39.method775();
                  Client.field330.offset = 0;
                  Client.field370.offset = 0;
                  Client.packetOpcode = -1;
                  Client.field482 = 1;
                  Client.field338 = -1;
                  Client.field339 = -1;
                  Client.field335 = 0;
                  Client.field301 = 0;
                  Client.field405 = 0;
                  Client.field302 = 0;
                  Client.menuOptionCount = 0;
                  Client.isMenuOpen = false;
                  class26.method615(0);
                  class47.chatLineMap.clear();
                  class47.field925.method2372();
                  class47.field930.method2522();
                  class47.field927 = 0;
                  Client.field438 = 0;
                  Client.field440 = false;
                  Client.field527 = 0;
                  Client.field351 = (int)(Math.random() * 100.0D) - 50;
                  Client.field353 = (int)(Math.random() * 110.0D) - 55;
                  Client.field355 = (int)(Math.random() * 80.0D) - 40;
                  Client.mapScale = (int)(Math.random() * 120.0D) - 60;
                  Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field521 = 0;
                  Client.field514 = -1;
                  Client.flagX = 0;
                  Client.flagY = 0;
                  Client.field310 = class40.field806;
                  Client.field487 = class40.field806;
                  Client.field326 = 0;
                  DecorativeObject.method1951();

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.cachedPlayers[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     Client.cachedNPCs[var0] = null;
                  }

                  Client.field525 = -1;
                  Client.projectiles.method2453();
                  Client.field421.method2453();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItemDeque[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.field419 = new Deque();
                  Client.field553 = 0;
                  Client.friendCount = 0;
                  Client.ignoreCount = 0;

                  for(var0 = 0; var0 < class187.field2773; ++var0) {
                     class187 var17 = class179.method3314(var0);
                     if(null != var17) {
                        class146.settings[var0] = 0;
                        class146.widgetSettings[var0] = 0;
                     }
                  }

                  class3.chatMessages.method849();
                  Client.field459 = -1;
                  if(Client.widgetRoot != -1) {
                     class142.method2746(Client.widgetRoot);
                  }

                  for(WidgetNode var14 = (WidgetNode)Client.componentTable.method2414(); null != var14; var14 = (WidgetNode)Client.componentTable.method2409()) {
                     XGrandExchangeOffer.method68(var14, true);
                  }

                  Client.widgetRoot = -1;
                  Client.componentTable = new XHashTable(8);
                  Client.field449 = null;
                  Client.isMenuOpen = false;
                  Client.menuOptionCount = 0;
                  Client.field415.method2794((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.field414[var0] = null;
                     Client.field434[var0] = false;
                  }

                  class138.method2533();
                  Client.field280 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field490[var0] = true;
                  }

                  class34.method730();
                  Client.field512 = null;
                  class60.field1072 = 0;
                  class164.clanMembers = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
                  }

                  class3.field33 = null;
                  class32.method705(Client.field370);
                  class40.field807 = -1;
                  class9.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field452 == 11 && FileOnDisk.field1183.method2105() >= 2) {
                  Client.field370.offset = 0;
                  FileOnDisk.field1183.method2106(Client.field370.payload, 0, 2);
                  Client.field370.offset = 0;
                  Projectile.field880 = Client.field370.readUnsignedShort();
                  Client.field452 = 12;
               }

               if(Client.field452 == 12 && FileOnDisk.field1183.method2105() >= Projectile.field880) {
                  Client.field370.offset = 0;
                  FileOnDisk.field1183.method2106(Client.field370.payload, 0, Projectile.field880);
                  Client.field370.offset = 0;
                  String var13 = Client.field370.method3057();
                  String var7 = Client.field370.method3057();
                  String var15 = Client.field370.method3057();
                  class3.method44(var13, var7, var15);
                  class186.setGameState(10);
               }

               if(Client.field452 != 13) {
                  ++Client.field322;
                  if(Client.field322 > 2000) {
                     if(Client.field323 < 1) {
                        if(class20.field219 == class5.field55) {
                           class5.field55 = class36.field770;
                        } else {
                           class5.field55 = class20.field219;
                        }

                        ++Client.field323;
                        Client.field452 = 0;
                     } else {
                        RSCanvas.method2130(-3);
                     }
                  }
               } else {
                  if(Client.field564 == -1) {
                     if(FileOnDisk.field1183.method2105() < 2) {
                        return;
                     }

                     FileOnDisk.field1183.method2106(Client.field370.payload, 0, 2);
                     Client.field370.offset = 0;
                     Client.field564 = Client.field370.readUnsignedShort();
                  }

                  if(FileOnDisk.field1183.method2105() >= Client.field564) {
                     FileOnDisk.field1183.method2106(Client.field370.payload, 0, Client.field564);
                     Client.field370.offset = 0;
                     var0 = Client.field564;
                     Client.field330.offset = 0;
                     Client.field370.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field482 = 1;
                     Client.field338 = -1;
                     Client.field339 = -1;
                     Client.field564 = 0;
                     Client.field335 = 0;
                     Client.field301 = 0;
                     Client.menuOptionCount = 0;
                     Client.isMenuOpen = false;
                     Client.field521 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     class40.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var16 = Client.cachedNPCs[var1];
                        if(null != var16) {
                           var16.interacting = -1;
                           var16.field622 = false;
                        }
                     }

                     class138.method2533();
                     class186.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field490[var1] = true;
                     }

                     class34.method730();
                     class32.method705(Client.field370);
                     if(var0 != Client.field370.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var9) {
         if(Client.field323 < 1) {
            if(class5.field55 == class20.field219) {
               class5.field55 = class36.field770;
            } else {
               class5.field55 = class20.field219;
            }

            ++Client.field323;
            Client.field452 = 0;
         } else {
            RSCanvas.method2130(-2);
         }
      }
   }

   protected void finalize() {
      this.method2121();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-610447563"
   )
   public int method2104() throws IOException {
      return this.field1747?0:this.field1755.read();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1922292161"
   )
   public int method2105() throws IOException {
      return this.field1747?0:this.field1755.available();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "0"
   )
   public void method2106(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1747) {
         while(var3 > 0) {
            int var4 = this.field1755.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1276611297"
   )
   public void method2107(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1747) {
         if(this.field1754) {
            this.field1754 = false;
            throw new IOException();
         } else {
            if(null == this.field1744) {
               this.field1744 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field1744[this.field1752] = var1[var5 + var2];
                  this.field1752 = (this.field1752 + 1) % 5000;
                  if((this.field1750 + 4900) % 5000 == this.field1752) {
                     throw new IOException();
                  }
               }

               if(this.field1749 == null) {
                  this.field1749 = this.field1748.method2000(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field1750 == this.field1752) {
                     if(this.field1747) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1750;
                  if(this.field1752 >= this.field1750) {
                     var1 = this.field1752 - this.field1750;
                  } else {
                     var1 = 5000 - this.field1750;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field1753.write(this.field1744, var2, var1);
               } catch (IOException var9) {
                  this.field1754 = true;
               }

               this.field1750 = (var1 + this.field1750) % 5000;

               try {
                  if(this.field1750 == this.field1752) {
                     this.field1753.flush();
                  }
               } catch (IOException var8) {
                  this.field1754 = true;
               }
               continue;
            }

            try {
               if(null != this.field1755) {
                  this.field1755.close();
               }

               if(null != this.field1753) {
                  this.field1753.close();
               }

               if(null != this.field1746) {
                  this.field1746.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field1744 = null;
            break;
         }
      } catch (Exception var12) {
         class39.reportException((String)null, var12);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;S)LSpritePixels;",
      garbageValue = "155"
   )
   public static SpritePixels method2113(class182 var0, String var1, String var2) {
      int var3 = var0.method3350(var1);
      int var4 = var0.method3345(var3, var2);
      return class207.method3894(var0, var3, var4);
   }

   public class110(Socket var1, class103 var2) throws IOException {
      this.field1748 = var2;
      this.field1746 = var1;
      this.field1746.setSoTimeout(30000);
      this.field1746.setTcpNoDelay(true);
      this.field1746.setReceiveBufferSize(16384);
      this.field1746.setSendBufferSize(16384);
      this.field1755 = this.field1746.getInputStream();
      this.field1753 = this.field1746.getOutputStream();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2072123259"
   )
   public void method2121() {
      if(!this.field1747) {
         synchronized(this) {
            this.field1747 = true;
            this.notifyAll();
         }

         if(this.field1749 != null) {
            while(this.field1749.field1661 == 0) {
               class0.method12(1L);
            }

            if(this.field1749.field1661 == 1) {
               try {
                  ((Thread)this.field1749.field1663).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1749 = null;
      }
   }
}
