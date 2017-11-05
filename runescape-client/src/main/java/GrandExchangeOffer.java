import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("h")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("d")
   static int[][] field315;
   @ObfuscatedName("w")
   @Export("progress")
   byte progress;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1204360795
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -706180633
   )
   @Export("price")
   public int price;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 300768847
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 823310939
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1718883181
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lfz;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "36289353"
   )
   public int method99() {
      return this.progress & 7;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2037759900"
   )
   public int method100() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-696884162"
   )
   void method101(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1537681073"
   )
   void method102(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1853304022"
   )
   public static void method116() {
      class281.field3766 = new CombatInfoList();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1875907860"
   )
   static void method112(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.field760 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "453"
   )
   public static void method115(int var0) {
      if(class203.field2500 != 0) {
         class10.field268 = var0;
      } else {
         class203.field2499.method3834(var0);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILhy;I)Lct;",
      garbageValue = "2080282077"
   )
   static Script method113(int var0, class219 var1) {
      Script var2 = (Script)Script.field1522.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = WorldMapType1.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = WorldMapType1.indexScripts.method4230(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = class22.method172(var5);
               if(var2 != null) {
                  Script.field1522.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-19"
   )
   static final void method114(String var0) {
      if(var0 != null) {
         String var1 = WidgetNode.method1087(var0, Permission.field3169);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = WidgetNode.method1087(var4, Permission.field3169);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.ignoreCount;

                  for(int var7 = var2; var7 < Client.ignoreCount; ++var7) {
                     Client.ignores[var7] = Client.ignores[var7 + 1];
                  }

                  Client.field1191 = Client.cycleCntr;
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DELETE_IGNORE);
                  Client.secretPacketBuffer1.putByte(class86.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
                  break;
               }
            }

         }
      }
   }
}
