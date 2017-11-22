import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class39 {
   @ObfuscatedName("oq")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   static class115 field497;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2062992233
   )
   public final int field498;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   public final Coordinates field492;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   public final Coordinates field491;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1698117767
   )
   final int field489;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1861822223
   )
   final int field493;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   final class33 field494;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1755078265
   )
   int field495;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 776924119
   )
   int field490;

   @ObfuscatedSignature(
      signature = "(ILhk;Lhk;Lar;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field498 = var1;
      this.field491 = var2;
      this.field492 = var3;
      this.field494 = var4;
      Area var5 = Area.mapAreaType[this.field498];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field489 = var6.width;
         this.field493 = var6.height;
      } else {
         this.field489 = 0;
         this.field493 = 0;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-122"
   )
   boolean method510(int var1, int var2) {
      return this.method511(var1, var2)?true:this.method512(var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-334438780"
   )
   boolean method511(int var1, int var2) {
      Area var3 = Area.mapAreaType[this.field498];
      switch(var3.field3361.field3597) {
      case 0:
         if(var1 > this.field495 - this.field489 && var1 <= this.field495) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field495 - this.field489 / 2 && var1 <= this.field489 / 2 + this.field495) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field495 || var1 >= this.field489 + this.field495) {
            return false;
         }
      }

      switch(var3.field3344.field3327) {
      case 0:
         if(var2 >= this.field490 - this.field493 / 2 && var2 <= this.field493 / 2 + this.field490) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.field490 || var2 >= this.field493 + this.field490) {
            return false;
         }
         break;
      case 2:
         if(var2 <= this.field490 - this.field493 || var2 > this.field490) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1571010524"
   )
   boolean method512(int var1, int var2) {
      return this.field494 == null?false:(var1 >= this.field495 - this.field494.field432 / 2 && var1 <= this.field494.field432 / 2 + this.field495?var2 >= this.field490 && var2 <= this.field494.field437 + this.field490:false);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-1951048920"
   )
   static int method518(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class82.intStack[++class82.intStackSize - 1] = MouseInput.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            var3 = class23.method170();
            if(var3 != null) {
               class82.intStack[++class82.intStackSize - 1] = var3.id;
               class82.intStack[++class82.intStackSize - 1] = var3.mask;
               class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var3.activity;
               class82.intStack[++class82.intStackSize - 1] = var3.location;
               class82.intStack[++class82.intStackSize - 1] = var3.playerCount;
               class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var3.address;
            } else {
               class82.intStack[++class82.intStackSize - 1] = -1;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var3 = class37.method478();
            if(var3 != null) {
               class82.intStack[++class82.intStackSize - 1] = var3.id;
               class82.intStack[++class82.intStackSize - 1] = var3.mask;
               class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var3.activity;
               class82.intStack[++class82.intStackSize - 1] = var3.location;
               class82.intStack[++class82.intStackSize - 1] = var3.playerCount;
               class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var3.address;
            } else {
               class82.intStack[++class82.intStackSize - 1] = -1;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var7;
            if(var0 == 6506) {
               var7 = class82.intStack[--class82.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var7 == class54.worldList[var5].id) {
                     var4 = class54.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class82.intStack[++class82.intStackSize - 1] = var4.id;
                  class82.intStack[++class82.intStackSize - 1] = var4.mask;
                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var4.activity;
                  class82.intStack[++class82.intStackSize - 1] = var4.location;
                  class82.intStack[++class82.intStackSize - 1] = var4.playerCount;
                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var4.address;
               } else {
                  class82.intStack[++class82.intStackSize - 1] = -1;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class82.intStackSize -= 4;
               var7 = class82.intStack[class82.intStackSize];
               boolean var10 = class82.intStack[class82.intStackSize + 1] == 1;
               var5 = class82.intStack[class82.intStackSize + 2];
               boolean var6 = class82.intStack[class82.intStackSize + 3] == 1;
               if(class54.worldList != null) {
                  class41.method560(0, class54.worldList.length - 1, var7, var10, var5, var6);
               }

               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field994 = class82.intStack[--class82.intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  class258 var9;
                  if(var0 == 6513) {
                     class82.intStackSize -= 2;
                     var7 = class82.intStack[class82.intStackSize];
                     var8 = class82.intStack[class82.intStackSize + 1];
                     var9 = VarPlayerType.method4260(var8);
                     if(var9.method4429()) {
                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = class211.getNpcDefinition(var7).method4641(var8, var9.field3437);
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = class211.getNpcDefinition(var7).method4668(var8, var9.field3436);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class82.intStackSize -= 2;
                     var7 = class82.intStack[class82.intStackSize];
                     var8 = class82.intStack[class82.intStackSize + 1];
                     var9 = VarPlayerType.method4260(var8);
                     if(var9.method4429()) {
                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = ClientPacket.getObjectDefinition(var7).method4522(var8, var9.field3437);
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = ClientPacket.getObjectDefinition(var7).method4521(var8, var9.field3436);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class82.intStackSize -= 2;
                     var7 = class82.intStack[class82.intStackSize];
                     var8 = class82.intStack[class82.intStackSize + 1];
                     var9 = VarPlayerType.method4260(var8);
                     if(var9.method4429()) {
                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = class139.getItemDefinition(var7).method4577(var8, var9.field3437);
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = class139.getItemDefinition(var7).method4610(var8, var9.field3436);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class82.intStackSize -= 2;
                     var7 = class82.intStack[class82.intStackSize];
                     var8 = class82.intStack[class82.intStackSize + 1];
                     var9 = VarPlayerType.method4260(var8);
                     if(var9.method4429()) {
                        class82.scriptStringStack[++class259.scriptStringStackSize - 1] = class226.method4077(var7).method4448(var8, var9.field3437);
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = class226.method4077(var7).method4442(var8, var9.field3436);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class82.intStack[++class82.intStackSize - 1] = 0;
                     return 1;
                  } else {
                     return var0 == 6520?1:(var0 == 6521?1:2);
                  }
               }
            } else {
               var7 = class82.intStack[--class82.intStackSize];
               if(var7 >= 0 && var7 < World.worldCount) {
                  var4 = class54.worldList[var7];
                  class82.intStack[++class82.intStackSize - 1] = var4.id;
                  class82.intStack[++class82.intStackSize - 1] = var4.mask;
                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var4.activity;
                  class82.intStack[++class82.intStackSize - 1] = var4.location;
                  class82.intStack[++class82.intStackSize - 1] = var4.playerCount;
                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = var4.address;
               } else {
                  class82.intStack[++class82.intStackSize - 1] = -1;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class259.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-40"
   )
   static final void method509() {
      PacketNode var0 = class18.method133(ClientPacket.field2301, Client.field905.field1460);
      Client.field905.method1855(var0);

      for(WidgetNode var1 = (WidgetNode)Client.componentTable.method3592(); var1 != null; var1 = (WidgetNode)Client.componentTable.method3593()) {
         if(var1.owner == 0 || var1.owner == 3) {
            class74.method1100(var1, true);
         }
      }

      if(Client.field878 != null) {
         ScriptEvent.method1038(Client.field878);
         Client.field878 = null;
      }

   }
}
