import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
public class class308 extends class221 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1248994853
   )
   public int field3876;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   public Name field3877;
   @ObfuscatedName("h")
   public short field3875;

   @ObfuscatedSignature(
      signature = "(Lkz;I)V"
   )
   class308(Name var1, int var2) {
      this.field3876 = (int)(class64.method1118() / 1000L);
      this.field3877 = var1;
      this.field3875 = (short)var2;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(Lin;IB)I",
      garbageValue = "-94"
   )
   static final int executeScript(Widget widget, int id) {
      if(widget.dynamicValues != null && id < widget.dynamicValues.length) {
         try {
            int[] script = widget.dynamicValues[id];
            int accumulator = 0;
            int counter = 0;
            byte operator = 0;

            while(true) {
               int instruction = script[counter++];
               int value = 0;
               byte next = 0;
               if(instruction == 0) {
                  return accumulator;
               }

               if(instruction == 1) {
                  value = Client.boostedSkillLevels[script[counter++]];
               }

               if(instruction == 2) {
                  value = Client.realSkillLevels[script[counter++]];
               }

               if(instruction == 3) {
                  value = Client.skillExperiences[script[counter++]];
               }

               int skill;
               Widget other;
               int item;
               int var12;
               if(instruction == 4) {
                  skill = script[counter++] << 16;
                  skill += script[counter++];
                  other = class44.getWidget(skill);
                  item = script[counter++];
                  if(item != -1 && (!class47.getItemDefinition(item).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < other.itemIds.length; ++var12) {
                        if(item + 1 == other.itemIds[var12]) {
                           value += other.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(instruction == 5) {
                  value = class237.clientVarps[script[counter++]];
               }

               if(instruction == 6) {
                  value = SkillConstants.SKILL_EXPERIENCE[Client.realSkillLevels[script[counter++]] - 1];
               }

               if(instruction == 7) {
                  value = class237.clientVarps[script[counter++]] * 100 / 46875;
               }

               if(instruction == 8) {
                  value = SoundTaskDataProvider.localPlayer.combatLevel;
               }

               if(instruction == 9) {
                  for(skill = 0; skill < 25; ++skill) {
                     if(SkillConstants.ENABLED_SKILLS[skill]) {
                        value += Client.realSkillLevels[skill];
                     }
                  }
               }

               if(instruction == 10) {
                  skill = script[counter++] << 16;
                  skill += script[counter++];
                  other = class44.getWidget(skill);
                  item = script[counter++];
                  if(item != -1 && (!class47.getItemDefinition(item).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < other.itemIds.length; ++var12) {
                        if(item + 1 == other.itemIds[var12]) {
                           value = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(instruction == 11) {
                  value = Client.energy;
               }

               if(instruction == 12) {
                  value = Client.weight;
               }

               if(instruction == 13) {
                  skill = class237.clientVarps[script[counter++]];
                  int var13 = script[counter++];
                  value = (skill & 1 << var13) != 0?1:0;
               }

               if(instruction == 14) {
                  skill = script[counter++];
                  value = DynamicObject.getVarbit(skill);
               }

               if(instruction == 15) {
                  next = 1;
               }

               if(instruction == 16) {
                  next = 2;
               }

               if(instruction == 17) {
                  next = 3;
               }

               if(instruction == 18) {
                  value = (SoundTaskDataProvider.localPlayer.x >> 7) + class138.baseX;
               }

               if(instruction == 19) {
                  value = (SoundTaskDataProvider.localPlayer.y >> 7) + class23.baseY;
               }

               if(instruction == 20) {
                  value = script[counter++];
               }

               if(next == 0) {
                  if(operator == 0) {
                     accumulator += value;
                  }

                  if(operator == 1) {
                     accumulator -= value;
                  }

                  if(operator == 2 && value != 0) {
                     accumulator /= value;
                  }

                  if(operator == 3) {
                     accumulator *= value;
                  }

                  operator = 0;
               } else {
                  operator = next;
               }
            }
         } catch (Exception ex) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
