import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "[Lkm;"
   )
   @Export("slArrowSprites")
   static IndexedSprite[] slArrowSprites;
   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field438;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1839307921
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("v")
   String field427;
   @ObfuscatedName("y")
   String field428;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1527519899
   )
   int field426;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1196055875
   )
   int field430;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   Coordinates field431;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -600863119
   )
   int field437;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 714127279
   )
   int field434;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -500329839
   )
   int field436;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -112337083
   )
   int field440;
   @ObfuscatedName("z")
   boolean field442;
   @ObfuscatedName("u")
   LinkedList field433;

   public WorldMapData() {
      this.fileId = -1;
      this.field426 = -1;
      this.field430 = -1;
      this.field431 = null;
      this.field437 = Integer.MAX_VALUE;
      this.field434 = 0;
      this.field436 = Integer.MAX_VALUE;
      this.field440 = 0;
      this.field442 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "-1689575172"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field427 = var1.readString();
      this.field428 = var1.readString();
      this.field431 = new Coordinates(var1.readInt());
      this.field426 = var1.readInt();
      var1.readUnsignedByte();
      this.field442 = var1.readUnsignedByte() == 1;
      this.field430 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field433 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field433.add(this.method275(var1));
      }

      this.method280();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgv;I)Lal;",
      garbageValue = "-2115507537"
   )
   WorldMapSectionBase method275(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)class34.forOrdinal(class27.method202(), var2);
      Object var4 = null;
      switch(var3.field387) {
      case 0:
         var4 = new WorldMapType2();
         break;
      case 1:
         var4 = new WorldMapType1();
         break;
      case 2:
         var4 = new class48();
         break;
      case 3:
         var4 = new WorldMapType3();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod700(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1565608816"
   )
   public boolean method276(int var1, int var2, int var3) {
      Iterator var4 = this.field433.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod696(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-466378243"
   )
   public boolean method296(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field437 && var3 <= this.field434) {
         if(var4 >= this.field436 && var4 <= this.field440) {
            Iterator var5 = this.field433.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod697(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "72681331"
   )
   public int[] method322(int var1, int var2, int var3) {
      Iterator var4 = this.field433.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod696(var1, var2, var3));

      return var5.vmethod716(var1, var2, var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Lht;",
      garbageValue = "1298853147"
   )
   public Coordinates method279(int var1, int var2) {
      Iterator var3 = this.field433.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod697(var1, var2));

      return var4.vmethod694(var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1368549803"
   )
   void method280() {
      Iterator var1 = this.field433.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod695(this);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "28402"
   )
   public int method281() {
      return this.fileId;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-611723492"
   )
   public boolean method333() {
      return this.field442;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1360974054"
   )
   public String method278() {
      return this.field427;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "186503942"
   )
   public String method284() {
      return this.field428;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-278599015"
   )
   int method320() {
      return this.field426;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-122"
   )
   public int method288() {
      return this.field430;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1680831226"
   )
   public int method297() {
      return this.field437;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "34"
   )
   public int method326() {
      return this.field434;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2059830066"
   )
   public int method289() {
      return this.field436;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "763709997"
   )
   public int method290() {
      return this.field440;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1667439505"
   )
   public int method274() {
      return this.field431.worldX;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1272513426"
   )
   public int method292() {
      return this.field431.plane;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1891550185"
   )
   public int method293() {
      return this.field431.worldY;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Lht;",
      garbageValue = "0"
   )
   public Coordinates method294() {
      return new Coordinates(this.field431);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfl;ZI)V",
      garbageValue = "-872602772"
   )
   public static void method340(class159 var0, boolean var1) {
      if(class249.NetCache_socket != null) {
         try {
            class249.NetCache_socket.vmethod3136();
         } catch (Exception var6) {
            ;
         }

         class249.NetCache_socket = null;
      }

      class249.NetCache_socket = var0;
      Overlay.sendConInfo(var1);
      class249.NetCache_responseHeaderBuffer.offset = 0;
      class29.currentRequest = null;
      class231.NetCache_responseArchiveBuffer = null;
      class249.field3360 = 0;

      while(true) {
         FileRequest var2 = (FileRequest)class249.NetCache_pendingPriorityResponses.first();
         if(var2 == null) {
            while(true) {
               var2 = (FileRequest)class249.NetCache_pendingResponses.first();
               if(var2 == null) {
                  if(class249.field3364 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.putByte(4);
                        var7.putByte(class249.field3364);
                        var7.putShort(0);
                        class249.NetCache_socket.vmethod3166(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class249.NetCache_socket.vmethod3136();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class249.field3362;
                        class249.NetCache_socket = null;
                     }
                  }

                  class249.field3359 = 0;
                  class249.field3346 = class60.currentTimeMs();
                  return;
               }

               class249.NetCache_pendingWritesQueue.setHead(var2);
               class249.NetCache_pendingWrites.put(var2, var2.hash);
               ++class249.NetCache_pendingWritesCount;
               --class249.NetCache_pendingResponsesCount;
            }
         }

         class249.NetCache_pendingPriorityWrites.put(var2, var2.hash);
         ++class249.NetCache_pendingPriorityWritesCount;
         --class249.NetCache_pendingPriorityResponsesCount;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lkh;I)Ljava/lang/String;",
      garbageValue = "-607234023"
   )
   @Export("cleanUsername")
   public static String cleanUsername(CharSequence var0, JagexLoginType var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }

            --var3;
         }

         int var11 = var3 - var2;
         if(var11 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3929) {
               case 8:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var11 <= var6) {
               StringBuilder var10 = new StringBuilder(var11);

               for(int var12 = var2; var12 < var3; ++var12) {
                  char var7 = var0.charAt(var12);
                  if(class216.method4029(var7)) {
                     char var8;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var8 = '_';
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var8 = var7;
                        break;
                     case 'À':
                     case 'Á':
                     case 'Â':
                     case 'Ã':
                     case 'Ä':
                     case 'à':
                     case 'á':
                     case 'â':
                     case 'ã':
                     case 'ä':
                        var8 = 'a';
                        break;
                     case 'Ç':
                     case 'ç':
                        var8 = 'c';
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var8 = 'e';
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var8 = 'i';
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var8 = 'n';
                        break;
                     case 'Ò':
                     case 'Ó':
                     case 'Ô':
                     case 'Õ':
                     case 'Ö':
                     case 'ò':
                     case 'ó':
                     case 'ô':
                     case 'õ':
                     case 'ö':
                        var8 = 'o';
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var8 = 'u';
                        break;
                     case 'ß':
                        var8 = 'b';
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var8 = 'y';
                        break;
                     default:
                        var8 = Character.toLowerCase(var7);
                     }

                     if(var8 != 0) {
                        var10.append(var8);
                     }
                  }
               }

               if(var10.length() == 0) {
                  return null;
               }

               return var10.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgv;II)Ljava/lang/String;",
      garbageValue = "340017173"
   )
   static String method341(Buffer var0, int var1) {
      try {
         int var2 = var0.getUSmart();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class276.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = WorldComparator.getString(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-10689"
   )
   public static final boolean method343() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field600 == KeyFocusListener.field618) {
            return false;
         } else {
            TextureProvider.field1683 = KeyFocusListener.field613[KeyFocusListener.field600];
            class37.field491 = KeyFocusListener.field612[KeyFocusListener.field600];
            KeyFocusListener.field600 = KeyFocusListener.field600 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(Lbc;I)V",
      garbageValue = "1202606426"
   )
   static final void method338(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class45.region.method2762(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class45.region.method2773(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class45.region.method2774(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class45.region.method2775(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class45.region.getObjectFlags(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1140 = var2;
      var0.field1142 = var3;
      var0.field1141 = var4;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Lbf;IIII)V",
      garbageValue = "-713810215"
   )
   static final void method339(Player var0, int var1, int var2, int var3) {
      if(GrandExchangeOffer.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class31.method272(var0.combatLevel, GrandExchangeOffer.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               DecorativeObject.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class54.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((MouseRecorder.field817 & 8) == 8) {
                  DecorativeObject.addMenuEntry(Client.field1013, Client.field1014 + " " + "->" + " " + class54.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(AttackOption.AttackOption_hidden == Client.playerAttackOption) {
                           continue;
                        }

                        if(Client.playerAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.playerAttackOption && var0.combatLevel > GrandExchangeOffer.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(GrandExchangeOffer.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == GrandExchangeOffer.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.playerMenuTypes[var5] + var6;
                     DecorativeObject.addMenuEntry(Client.playerOptions[var5], class54.getColTags(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class54.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
