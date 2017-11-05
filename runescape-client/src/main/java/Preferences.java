import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("cl")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 158720685
   )
   static int field1301;
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   static BuildType field1308;
   @ObfuscatedName("q")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("o")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1288277255
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("v")
   String field1299;
   @ObfuscatedName("p")
   boolean field1305;
   @ObfuscatedName("e")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1301 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.field1299 = null;
      this.field1305 = false;
      this.preferences = new LinkedHashMap();
      this.method1580(true);
   }

   @ObfuscatedSignature(
      signature = "(Lfz;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.field1299 = null;
      this.field1305 = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1301) {
            if(var1.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if(var2 > 1) {
               this.muted = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.screenType = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.field1299 = var1.getNullString();
            }

            if(var2 > 5) {
               this.field1305 = var1.method3278();
            }
         } else {
            this.method1580(true);
         }
      } else {
         this.method1580(true);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1513142394"
   )
   void method1580(boolean var1) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lfz;",
      garbageValue = "905643027"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1301);
      var1.putByte(this.hideRoofs?1:0);
      var1.putByte(this.muted?1:0);
      var1.putByte(this.screenType);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      var1.putString(this.field1299 != null?this.field1299:"");
      var1.method3367(this.field1305);
      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)[Lhr;",
      garbageValue = "-1240890257"
   )
   public static BuildType[] method1593() {
      return new BuildType[]{BuildType.BUILD_LIVE, BuildType.LIVE, BuildType.WIP, BuildType.RC};
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-786678473"
   )
   static final void method1592(String var0) {
      if(!var0.equals("")) {
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_JOIN_CLANCHAT);
         Client.secretPacketBuffer1.putByte(class86.getLength(var0));
         Client.secretPacketBuffer1.putString(var0);
      }
   }
}
